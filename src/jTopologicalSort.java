import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Arrays;

public class jTopologicalSort {

    static int[] topologicalSort(
            int n,
            List<List<Integer>> adj,
            int[] indegree) {

        Queue<Integer> queue = new ArrayDeque<>();

        // Step 1: Find vertices with indegree zero
        for (int i = 0; i < n; i++) {

            if (indegree[i] == 0) {

                queue.offer(i);
            }
        }

        int[] order = new int[n];

        int index = 0;

        // Step 2: Process vertices using BFS
        while (!queue.isEmpty()) {

            int current = queue.poll();

            // Add current vertex to result
            order[index++] = current;

            // Remove its outgoing edges
            for (int neighbour : adj.get(current)) {

                indegree[neighbour]--;

                // If indegree becomes zero,
                // add neighbour to queue
                if (indegree[neighbour] == 0) {

                    queue.offer(neighbour);
                }
            }
        }

        // Step 3: Check for cycle
        if (index != n) {

            return new int[0];
        }

        return order;
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

            // Directed edge u -> v
            adj.get(u).add(v);

            indegree[v]++;
        }

        int[] result = topologicalSort(
            n,
            adj,
            indegree
        );

        if (result.length == 0) {

            System.out.println("[]");

        } else {

            System.out.println(Arrays.toString(result));
        }

        sc.close();
    }
}