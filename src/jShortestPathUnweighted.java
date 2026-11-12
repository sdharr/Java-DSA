
import java.util.*;

public class jShortestPathUnweighted {

    public static int[] shortestPath(
            int n, List<List<Integer>> adj, int source) {

        int[] dist = new int[n];

        // -1 means not visited / unreachable
        Arrays.fill(dist, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        dist[source] = 0;
        queue.offer(source);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int neighbor : adj.get(current)) {

                if (dist[neighbor] == -1) {

                    dist[neighbor] = dist[current] + 1;

                    queue.offer(neighbor);
                }
            }
        }

        return dist;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < m; i++) {

            int u = sc.nextInt();
            int v = sc.nextInt();

            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        int source = sc.nextInt();

        int[] result = shortestPath(n, adj, source);

        System.out.println(Arrays.toString(result));

        sc.close();
    }
}

