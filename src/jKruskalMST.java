
import java.util.*;

public class jKruskalMST {

    static class Edge {
        int u, v, weight;

        Edge(int u, int v, int weight) {
            this.u = u;
            this.v = v;
            this.weight = weight;
        }
    }

    static class DSU {

        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        // Find the representative of a group
        int find(int x) {

            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        // Join two groups if they are different
        boolean union(int a, int b) {

            int rootA = find(a);
            int rootB = find(b);

            if (rootA == rootB) {
                return false;
            }

            // Attach smaller group to larger group
            if (size[rootA] < size[rootB]) {
                int temp = rootA;
                rootA = rootB;
                rootB = temp;
            }

            parent[rootB] = rootA;
            size[rootA] += size[rootB];

            return true;
        }
    }

    public static long kruskalMST(
            int n, List<Edge> edges) {

        // Sort edges by increasing weight
        edges.sort(Comparator.comparingInt(e -> e.weight));

        DSU dsu = new DSU(n);

        long totalWeight = 0;
        int edgesUsed = 0;

        for (Edge edge : edges) {

            // Only select edges that join different groups
            if (dsu.union(edge.u, edge.v)) {

                totalWeight += edge.weight;
                edgesUsed++;

                if (edgesUsed == n - 1) {
                    break;
                }
            }
        }

        if (n <= 1) {
            return 0;
        }

        // Not enough edges to connect all vertices
        if (edgesUsed != n - 1) {
            return -1;
        }

        return totalWeight;
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

        System.out.println(kruskalMST(n, edges));

        sc.close();
    }
}
