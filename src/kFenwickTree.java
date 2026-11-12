
import java.util.*;

public class kFenwickTree {

    static class FenwickTree {

        int n;
        long[] bit;

        // Constructor
        FenwickTree(int n) {
            this.n = n;
            bit = new long[n + 1];
        }

        // Add value at index
        void update(int index, long value) {

            while (index <= n) {

                bit[index] += value;

                index += index & -index;
            }
        }

        // Sum from index 1 to index
        long prefixSum(int index) {

            long sum = 0;

            while (index > 0) {

                sum += bit[index];

                index -= index & -index;
            }

            return sum;
        }

        // Sum from left to right (inclusive)
        long rangeSum(int left, int right) {

            return prefixSum(right)
                 - prefixSum(left - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        FenwickTree ft = new FenwickTree(n);

        // Read the initial array
        for (int i = 1; i <= n; i++) {

            long value = sc.nextLong();

            ft.update(i, value);
        }

        int q = sc.nextInt();

        for (int i = 0; i < q; i++) {

            int type = sc.nextInt();

            if (type == 1) {

                // 1 index value
                // Add value at index
                int index = sc.nextInt();
                long value = sc.nextLong();

                ft.update(index, value);

            } else if (type == 2) {

                // 2 index
                // Prefix sum
                int index = sc.nextInt();

                System.out.println(ft.prefixSum(index));

            } else if (type == 3) {

                // 3 left right
                // Range sum
                int left = sc.nextInt();
                int right = sc.nextInt();

                System.out.println(
                    ft.rangeSum(left, right)
                );
            }
        }

        sc.close();
    }
}
