import java.util.Scanner;

public class iSegmentTree {

    static class SegmentTree {

        private int n;
        private long[] tree;

        // Constructor
        SegmentTree(int[] arr) {

            n = arr.length;

            tree = new long[4 * n];

            build(arr, 1, 0, n - 1);
        }

        // Build the Segment Tree
        private void build(
                int[] arr,
                int node,
                int start,
                int end) {

            // Leaf node
            if (start == end) {

                tree[node] = arr[start];

                return;
            }

            int mid = start + (end - start) / 2;

            // Build left subtree
            build(arr, node * 2, start, mid);

            // Build right subtree
            build(arr, node * 2 + 1, mid + 1, end);

            // Store sum of both children
            tree[node] =
                    tree[node * 2] + tree[node * 2 + 1];
        }

        // Update an array element
        public void update(int index, int value) {

            if (index < 0 || index >= n) {
                throw new IndexOutOfBoundsException();
            }

            update(1, 0, n - 1, index, value);
        }

        private void update(
                int node,
                int start,
                int end,
                int index,
                int value) {

            // Find the required leaf node
            if (start == end) {

                tree[node] = value;

                return;
            }

            int mid = start + (end - start) / 2;

            if (index <= mid) {

                update(
                    node * 2,
                    start,
                    mid,
                    index,
                    value
                );

            } else {

                update(
                    node * 2 + 1,
                    mid + 1,
                    end,
                    index,
                    value
                );
            }

            // Recalculate current node's sum
            tree[node] =
                    tree[node * 2] + tree[node * 2 + 1];
        }

        // Calculate sum in the given range
        public long query(int left, int right) {

            if (left < 0 || right >= n || left > right) {
                throw new IndexOutOfBoundsException();
            }

            return query(1, 0, n - 1, left, right);
        }

        private long query(
                int node,
                int start,
                int end,
                int left,
                int right) {

            // Case 1: Complete overlap
            if (left <= start && end <= right) {

                return tree[node];
            }

            // Case 2: No overlap
            if (end < left || start > right) {

                return 0;
            }

            // Case 3: Partial overlap
            int mid = start + (end - start) / 2;

            long leftSum = query(
                node * 2,
                start,
                mid,
                left,
                right
            );

            long rightSum = query(
                node * 2 + 1,
                mid + 1,
                end,
                left,
                right
            );

            return leftSum + rightSum;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        SegmentTree segmentTree = new SegmentTree(arr);

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            String command = sc.next().toUpperCase();

            switch (command) {

                case "UPDATE":

                    int index = sc.nextInt();

                    int value = sc.nextInt();

                    segmentTree.update(index, value);

                    break;

                case "QUERY":

                    int left = sc.nextInt();

                    int right = sc.nextInt();

                    System.out.println(
                        segmentTree.query(left, right)
                    );

                    break;
            }
        }

        sc.close();
    }
}