
import java.util.*;

public class jFloydWarshall {

    static final long INF = Long.MAX_VALUE / 4;

    public static long[][] floydWarshall(long[][] dist) {

        int n = dist.length;

        for (int k = 0; k < n; k++) {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][k] != INF &&
                        dist[k][j] != INF) {

                        dist[i][j] = Math.min(
                            dist[i][j],
                            dist[i][k] + dist[k][j]
                        );
                    }
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        long[][] dist = new long[n][n];

        // Initialize distance matrix
        for (int i = 0; i < n; i++) {

            Arrays.fill(dist[i], INF);

            dist[i][i] = 0;
        }

        // Read directed weighted edges
        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();
            int w = sc.nextInt();

            dist[u][v] = Math.min(dist[u][v], w);
        }

        floydWarshall(dist);

        // Detect negative-weight cycles
        boolean negativeCycle = false;

        for (int i = 0; i < n; i++) {
            if (dist[i][i] < 0) {
                negativeCycle = true;
            }
        }

        if (negativeCycle) {
            System.out.println("Negative cycle detected");
        } else {

            for (int i = 0; i < n; i++) {

                for (int j = 0; j < n; j++) {

                    if (dist[i][j] == INF) {
                        System.out.print("-1 ");
                    } else {
                        System.out.print(dist[i][j] + " ");
                    }
                }

                System.out.println();
            }
        }

        sc.close();
    }
}
