
import java.util.*;

public class jDijkstra {

    public static long[] dijkstra(
            int n, List<List<int[]>> adj, int source) {

        long[] dist = new long[n];

        Arrays.fill(dist, Long.MAX_VALUE);

        dist[source] = 0;

        // Each entry: {vertex, distance}
        PriorityQueue<long[]> pq = new PriorityQueue<>(
            Comparator.comparingLong(a -> a[1])
        );

        pq.offer(new long[]{source, 0});

        while (!pq.isEmpty()) {

            long[] current = pq.poll();

            int u = (int) current[0];
            long currentDist = current[1];

            // Ignore outdated entries
            if (currentDist != dist[u]) {
                continue;
            }

            for (int[] edge : adj.get(u)) {

                int v = edge[0];
                int weight = edge[1];

                long newDist = dist[u] + weight;

                if (newDist < dist[v]) {

                    dist[v] = newDist;

                    pq.offer(new long[]{v, newDist});
                }
            }
        }

        // Convert unreachable distances to -1
        for (int i = 0; i < n; i++) {
            if (dist[i] == Long.MAX_VALUE) {
                dist[i] = -1;
            }
        }

        return dist;
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
            int weight = sc.nextInt();

            adj.get(u).add(new int[]{v, weight});
        }

        int source = sc.nextInt();

        long[] result = dijkstra(n, adj, source);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}
