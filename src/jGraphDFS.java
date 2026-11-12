import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class jGraphDFS {

    static List<Integer> dfs(
            int n,
            List<List<Integer>> adj,
            int start) {

        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[n];

        Deque<Integer> stack = new ArrayDeque<>();

        // Mark starting vertex as visited
        visited[start] = true;

        // Push starting vertex
        stack.push(start);

        while (!stack.isEmpty()) {

            // Remove the top vertex
            int current = stack.pop();

            // Record visited vertex
            result.add(current);

            List<Integer> neighbours = adj.get(current);

            // Push neighbours in reverse order
            // to preserve insertion-order DFS traversal
            for (int i = neighbours.size() - 1; i >= 0; i--) {

                int neighbour = neighbours.get(i);

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    stack.push(neighbour);
                }
            }
        }

        return result;
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

        // Read graph edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();

            int v = sc.nextInt();

            // Undirected graph
            adj.get(u).add(v);

            adj.get(v).add(u);
        }

        int start = sc.nextInt();

        List<Integer> result = dfs(n, adj, start);

        System.out.println(result);

        sc.close();
    }
}