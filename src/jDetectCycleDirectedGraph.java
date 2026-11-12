import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class jDetectCycleDirectedGraph {

    static boolean hasCycle(
            int n,
            List<List<Integer>> adj,
            int[] indegree) {

        Queue<Integer> queue = new ArrayDeque<>();

        // Step 1: Add all vertices with indegree zero
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int processed = 0;

        // Step 2: Perform BFS
        while (!queue.isEmpty()) {

            int current = queue.poll();

            processed++;

            // Remove outgoing edges
            for (int neighbour : adj.get(current)) {

                indegree[neighbour]--;

                // Add vertex when indegree becomes zero
                if (indegree[neighbour] == 0) {

                    queue.offer(neighbour);
                }
            }
        }

        // Step 3: Check whether all vertices were processed
        return processed != n;
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

        int[] indegree = new int[n];

        // Read directed edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();

            int v = sc.nextInt();

            // Directed edge: u -> v
            adj.get(u).add(v);

            indegree[v]++;
        }

        System.out.println(
            hasCycle(n, adj, indegree)
        );

        sc.close();
    }
}