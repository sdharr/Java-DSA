
import java.util.*;

public class kCoinChangeMinimum {

    public static int coinChange(int[] coins, int amount) {

        int[] dp = new int[amount + 1];

        // A value greater than the maximum possible answer
        int INF = amount + 1;

        Arrays.fill(dp, INF);

        // Zero coins are needed to make amount 0
        dp[0] = 0;

        for (int coin : coins) {

            for (int x = coin; x <= amount; x++) {

                if (dp[x - coin] != INF) {

                    dp[x] = Math.min(
                        dp[x],
                        dp[x - coin] + 1
                    );
                }
            }
        }

        if (dp[amount] == INF) {
            return -1;
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

        System.out.println(coinChange(coins, amount));

        sc.close();
    }
}

