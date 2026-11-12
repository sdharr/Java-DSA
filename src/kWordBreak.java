
import java.util.*;

public class kWordBreak {

    public static boolean wordBreak(
            String s, List<String> wordDict) {

        // Fast dictionary lookup
        Set<String> words = new HashSet<>(wordDict);

        // Find the longest dictionary word
        int maxLength = 0;

        for (String word : words) {
            maxLength = Math.max(
                maxLength, word.length()
            );
        }

        int n = s.length();

        boolean[] dp = new boolean[n + 1];

        // An empty prefix can always be formed
        dp[0] = true;

        for (int i = 1; i <= n; i++) {

            // Try possible lengths of the last word
            for (int len = 1;
                 len <= maxLength && len <= i;
                 len++) {

                int start = i - len;

                // Check the previous prefix first
                if (dp[start]) {

                    String part = s.substring(start, i);

                    if (words.contains(part)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }

        return dp[n];
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        int n = sc.nextInt();

        List<String> wordDict = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            wordDict.add(sc.next());
        }

        System.out.println(wordBreak(s, wordDict));

        sc.close();
    }
}
