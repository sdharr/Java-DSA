
import java.util.*;

public class kLongestCommonSubsequence {

    public static int longestCommonSubsequence(
            String a, String b) {

        int n = a.length();
        int m = b.length();

        int[] dp = new int[m + 1];

        for (int i = 1; i <= n; i++) {

            int prev = 0;

            for (int j = 1; j <= m; j++) {

                int old = dp[j];

                if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    dp[j] = prev + 1;

                } else {

                    dp[j] = Math.max(dp[j], dp[j - 1]);
                }

                prev = old;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(
            longestCommonSubsequence(a, b)
        );

        sc.close();
    }
}

