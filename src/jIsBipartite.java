
import java.util.*;

public class jIsBipartite {

    public static boolean isBipartite(
            List<List<Integer>> adj, int n) {

        int[] color = new int[n];

        // -1 means uncolored
        Arrays.fill(color, -1);

        Queue<Integer> queue = new ArrayDeque<>();

        // Handle disconnected graphs
        for (int start = 0; start < n; start++) {

            if (color[start] != -1) {
                continue;
            }

            color[start] = 0;
            queue.offer(start);

            while (!queue.isEmpty()) {

                int current = queue.poll();

                for (int neighbor : adj.get(current)) {

                    if (color[neighbor] == -1) {

                        // Assign opposite color
                        color[neighbor] = 1 - color[current];

                        queue.offer(neighbor);

                    } else if (color[neighbor] == color[current]) {

                        // Adjacent vertices have same color
                        return false;
                    }
                }
            }
        }

        return true;
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

        System.out.println(isBipartite(adj, n));

        sc.close();
    }
}
