
import java.util.*;

public class jBellmanFord {

    static class Edge {
        int from;
        int to;
        int weight;

        Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }

    public static long[] bellmanFord(
            int n, List<Edge> edges, int source) {

        long INF = Long.MAX_VALUE / 4;

        long[] dist = new long[n];

        Arrays.fill(dist, INF);
        dist[source] = 0;

        // Relax every edge at most n - 1 times
        for (int i = 1; i < n; i++) {

            boolean changed = false;

            for (Edge edge : edges) {

                int u = edge.from;
                int v = edge.to;
                int w = edge.weight;

                if (dist[u] != INF &&
                    dist[u] + w < dist[v]) {

                    dist[v] = dist[u] + w;
                    changed = true;
                }
            }

            // Stop if no distance changed
            if (!changed) {
                break;
            }
        }

        // Check for a reachable negative cycle
        for (Edge edge : edges) {

            int u = edge.from;
            int v = edge.to;
            int w = edge.weight;

            if (dist[u] != INF &&
                dist[u] + w < dist[v]) {

                return null;
            }
        }

        // Mark unreachable vertices
        for (int i = 0; i < n; i++) {
            if (dist[i] == INF) {
                dist[i] = -1;
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<Edge> edges = new ArrayList<>();

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            edges.add(new Edge(u, v, w));
        }

        int source = sc.nextInt();

        long[] result = bellmanFord(n, edges, source);

        if (result == null) {
            System.out.println("Negative cycle detected");
        } else {
            System.out.println(Arrays.toString(result));
        }

        sc.close();
    }
}
