
import java.util.*;

public class kKnapsack01 {

    public static int knapsack(
            int[] weights,
            int[] values,
            int capacity) {

        int[] dp = new int[capacity + 1];

        for (int i = 0; i < weights.length; i++) {

            int weight = weights[i];
            int value = values[i];

            // Traverse capacities backward
            for (int w = capacity; w >= weight; w--) {

                int take = dp[w - weight] + value;

                int skip = dp[w];

                dp[w] = Math.max(take, skip);
            }
        }

        return dp[capacity];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int capacity = sc.nextInt();

        int[] weights = new int[n];
        int[] values = new int[n];

        for (int i = 0; i < n; i++) {
            weights[i] = sc.nextInt();
        }

        for (int i = 0; i < n; i++) {
            values[i] = sc.nextInt();
        }

        System.out.println(
            knapsack(weights, values, capacity)
        );

        sc.close();
    }
}
