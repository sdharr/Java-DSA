
import java.util.*;

public class kMatrixChainMultiplication {

    public static long matrixChainMultiplication(
            int[] dimensions) {

        // Number of matrices
        int n = dimensions.length - 1;

        if (n <= 1) {
            return 0;
        }

        // dp[i][j] = minimum cost to multiply
        // matrices from i to j
        long[][] dp = new long[n][n];

        // Length of the matrix chain
        for (int len = 2; len <= n; len++) {

            // Starting matrix
            for (int i = 0; i + len <= n; i++) {

                int j = i + len - 1;

                dp[i][j] = Long.MAX_VALUE;

                // Try every possible split
                for (int k = i; k < j; k++) {

                    long leftCost = dp[i][k];

                    long rightCost = dp[k + 1][j];

                    long multiplyCost =
                        (long) dimensions[i]
                        * dimensions[k + 1]
                        * dimensions[j + 1];

                    long totalCost =
                        leftCost + rightCost + multiplyCost;

                    dp[i][j] = Math.min(
                        dp[i][j],
                        totalCost
                    );
                }
            }
        }

        return dp[0][n - 1];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of entries in dimensions
        int size = sc.nextInt();

        int[] dimensions = new int[size];

        for (int i = 0; i < size; i++) {
            dimensions[i] = sc.nextInt();
        }

        System.out.println(
            matrixChainMultiplication(dimensions)
        );

        sc.close();
    }
}
