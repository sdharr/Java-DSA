
import java.util.*;

public class kPartitionEqualSubsetSum {

    public static boolean canPartition(int[] nums) {

        int total = 0;

        // Calculate the total sum
        for (int num : nums) {
            total += num;
        }

        // An odd total cannot be split equally
        if (total % 2 != 0) {
            return false;
        }

        int target = total / 2;

        boolean[] dp = new boolean[target + 1];

        // Sum 0 is always possible
        dp[0] = true;

        for (int num : nums) {

            // Traverse backwards to use each
            // number at most once
            for (int sum = target; sum >= num; sum--) {

                dp[sum] = dp[sum] || dp[sum - num];
            }
        }

        return dp[target];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(canPartition(nums));

        sc.close();
    }
}
