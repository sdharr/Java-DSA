import java.util.Scanner;

public class iDisjointSetUnion {

    static class DSU {

        private int[] parent;
        private int[] size;

        // Initially, every element belongs to its own group
        DSU(int n) {

            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {

                parent[i] = i;

                size[i] = 1;
            }
        }

        // Find the representative of a group
        // Using Path Compression
        public int find(int x) {

            if (parent[x] != x) {

                parent[x] = find(parent[x]);
            }

            return parent[x];
        }

        // Merge two groups
        // Using Union by Size
        public boolean union(int a, int b) {

            int rootA = find(a);

            int rootB = find(b);

            // Already in the same group
            if (rootA == rootB) {
                return false;
            }

            // Attach smaller group to larger group
            if (size[rootA] < size[rootB]) {

                int temp = rootA;

                rootA = rootB;

                rootB = temp;
            }

            // Merge rootB into rootA
            parent[rootB] = rootA;

            // Update size
            size[rootA] += size[rootB];

            return true;
        }

        // Check whether two elements belong to the same group
        public boolean connected(int a, int b) {

            return find(a) == find(b);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int q = sc.nextInt();

        DSU dsu = new DSU(n);

        for (int i = 0; i < q; i++) {

            String command = sc.next().toUpperCase();

            switch (command) {

                case "UNION":

                    int a = sc.nextInt();

                    int b = sc.nextInt();

                    System.out.println(dsu.union(a, b));

                    break;

                case "FIND":

                    int x = sc.nextInt();

                    System.out.println(dsu.find(x));

                    break;

                case "CONNECTED":

                    int u = sc.nextInt();

                    int v = sc.nextInt();

                    System.out.println(dsu.connected(u, v));

                    break;
            }
        }

        sc.close();
    }
}