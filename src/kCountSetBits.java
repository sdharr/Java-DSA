
import java.util.*;

public class kCountSetBits {

    public static int[] countBits(int n) {

        int[] dp = new int[n + 1];

        // dp[0] is already 0

        for (int i = 1; i <= n; i++) {

            dp[i] = dp[i >> 1] + (i & 1);
        }

        return dp;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] result = countBits(n);

        for (int i = 0; i < result.length; i++) {

            if (i > 0) {
                System.out.print(" ");
            }

            System.out.print(result[i]);
        }

        System.out.println();

        sc.close();
    }
}
