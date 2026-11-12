import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class jConnectedComponents {

    static void dfs(
            int start,
            List<List<Integer>> adj,
            boolean[] visited) {

        Deque<Integer> stack = new ArrayDeque<>();

        visited[start] = true;

        stack.push(start);

        while (!stack.isEmpty()) {

            int current = stack.pop();

            // Explore all neighbours
            for (int neighbour : adj.get(current)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    stack.push(neighbour);
                }
            }
        }
    }

    static int countComponents(
            int n,
            List<List<Integer>> adj) {

        boolean[] visited = new boolean[n];

        int count = 0;

        // Check every vertex
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                // Found a new connected component
                count++;

                // Visit every vertex in this component
                dfs(i, adj, visited);
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int m = sc.nextInt();

        // Create adjacency list
        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {

            adj.add(new ArrayList<>());
        }

        // Read edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();

            int v = sc.nextInt();

            // Undirected graph
            adj.get(u).add(v);

            adj.get(v).add(u);
        }

        int result = countComponents(n, adj);

        System.out.println(result);

        sc.close();
    }
}