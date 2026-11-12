import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class jGraphBFS {

    static List<Integer> bfs(
            int n,
            List<List<Integer>> adj,
            int start) {

        List<Integer> result = new ArrayList<>();

        boolean[] visited = new boolean[n];

        Queue<Integer> queue = new ArrayDeque<>();

        // Mark starting vertex as visited
        visited[start] = true;

        // Add starting vertex to queue
        queue.offer(start);

        while (!queue.isEmpty()) {

            // Remove the front vertex
            int current = queue.poll();

            // Record the visited vertex
            result.add(current);

            // Explore its neighbours
            for (int neighbour : adj.get(current)) {

                if (!visited[neighbour]) {

                    visited[neighbour] = true;

                    queue.offer(neighbour);
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

        List<Integer> result = bfs(n, adj, start);

        System.out.println(result);

        sc.close();
    }
}