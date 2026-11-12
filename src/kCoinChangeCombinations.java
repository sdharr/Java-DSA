
import java.util.*;

public class kCoinChangeCombinations {

    public static long countCombinations(
            int[] coins, int amount) {

        long[] dp = new long[amount + 1];

        // One way to make zero: choose no coins
        dp[0] = 1;

        for (int coin : coins) {

            for (int x = coin; x <= amount; x++) {

                dp[x] = dp[x] + dp[x - coin];
            }
        }

        return dp[amount];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] coins = new int[n];

        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        int amount = sc.nextInt();

        System.out.println(
            countCombinations(coins, amount)
        );

        sc.close();
    }
}
