import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.ArrayDeque;

public class jDetectCycleUndirectedGraph {

    static boolean hasCycle(
            int n,
            List<List<Integer>> adj) {

        boolean[] visited = new boolean[n];

        Queue<int[]> queue = new ArrayDeque<>();

        // Check every connected component
        for (int i = 0; i < n; i++) {

            if (!visited[i]) {

                visited[i] = true;

                // Store {current node, parent node}
                queue.offer(new int[]{i, -1});

                while (!queue.isEmpty()) {

                    int[] current = queue.poll();

                    int node = current[0];
                    int parent = current[1];

                    // Explore neighbours
                    for (int neighbour : adj.get(node)) {

                        if (!visited[neighbour]) {

                            visited[neighbour] = true;

                            queue.offer(
                                new int[]{neighbour, node}
                            );

                        } else if (neighbour != parent) {

                            // Already visited neighbour
                            // that is not the parent: cycle found
                            return true;
                        }
                    }
                }
            }
        }

        return false;
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

        System.out.println(hasCycle(n, adj));

        sc.close();
    }
}