
import java.util.*;

public class kEditDistance {

    public static int editDistance(String a, String b) {

        int n = a.length();
        int m = b.length();

        int[] dp = new int[m + 1];

        // Convert empty string into prefixes of b
        for (int j = 0; j <= m; j++) {
            dp[j] = j;
        }

        for (int i = 1; i <= n; i++) {

            // Save the old diagonal value
            int diagonal = dp[0];

            // Converting first i characters of a
            // into an empty string needs i deletions
            dp[0] = i;

            for (int j = 1; j <= m; j++) {

                int old = dp[j];

                if (a.charAt(i - 1) == b.charAt(j - 1)) {

                    dp[j] = diagonal;

                } else {

                    int replace = diagonal;
                    int delete = old;
                    int insert = dp[j - 1];

                    dp[j] = 1 + Math.min(
                        replace,
                        Math.min(delete, insert)
                    );
                }

                // Move diagonal to the next column
                diagonal = old;
            }
        }

        return dp[m];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        System.out.println(editDistance(a, b));

        sc.close();
    }
}
