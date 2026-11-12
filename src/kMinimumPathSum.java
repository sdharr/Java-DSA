
import java.util.*;

public class kMinimumPathSum {

    public static long minPathSum(int[][] grid) {

        int m = grid.length;

        if (m == 0) {
            return 0;
        }

        int n = grid[0].length;

        if (n == 0) {
            return 0;
        }

        long[] dp = new long[n];

        // Starting cell
        dp[0] = grid[0][0];

        // Initialize the first row
        for (int c = 1; c < n; c++) {
            dp[c] = dp[c - 1] + grid[0][c];
        }

        // Process remaining rows
        for (int r = 1; r < m; r++) {

            // First column: can only come from above
            dp[0] += grid[r][0];

            for (int c = 1; c < n; c++) {

                long fromAbove = dp[c];

                long fromLeft = dp[c - 1];

                dp[c] = Math.min(
                    fromAbove,
                    fromLeft
                ) + grid[r][c];
            }
        }

        return dp[n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        int[][] grid = new int[m][n];

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                grid[r][c] = sc.nextInt();
            }
        }

        System.out.println(minPathSum(grid));

        sc.close();
    }
}
