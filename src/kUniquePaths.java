
import java.util.*;

public class kUniquePaths {

    public static long uniquePaths(int m, int n) {

        if (m <= 0 || n <= 0) {
            return 0;
        }

        long[] dp = new long[n];

        // First row: only one way to reach each cell
        Arrays.fill(dp, 1);

        // Process remaining rows
        for (int r = 1; r < m; r++) {

            for (int c = 1; c < n; c++) {

                dp[c] = dp[c] + dp[c - 1];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        System.out.println(uniquePaths(m, n));

        sc.close();
    }
}
