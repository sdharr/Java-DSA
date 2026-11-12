
import java.util.*;

public class jPrimMST {

    public static long primMST(
            int n, List<List<int[]>> adj) {

        if (n == 0) {
            return 0;
        }

        boolean[] visited = new boolean[n];

        // Each entry: {vertex, edgeWeight}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[1])
        );

        // Start from vertex 0 with cost 0
        pq.offer(new long[]{0, 0});

        long totalWeight = 0;
        int count = 0;

        while (!pq.isEmpty() && count < n) {

            long[] current = pq.poll();

            int u = (int) current[0];
            long weight = current[1];

            // Avoid selecting a vertex twice
            if (visited[u]) {
                continue;
            }

            visited[u] = true;
            totalWeight += weight;
            count++;

            // Explore neighboring edges
            for (int[] edge : adj.get(u)) {

                int v = edge[0];
                int edgeWeight = edge[1];

                if (!visited[v]) {
                    pq.offer(new long[]{v, edgeWeight});
                }
            }
        }

        // All vertices must be connected
        if (count != n) {
            return -1;
        }

        return totalWeight;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<int[]>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            // Undirected graph
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        System.out.println(primMST(n, adj));

        sc.close();
    }
}
