import java.util.Scanner;

public class cRabinKarp {

    static int rabinKarp(String text, String pattern) {

        int n = text.length();
        int m = pattern.length();

        if (m == 0) {
            return 0;
        }

        if (m > n) {
            return -1;
        }

        long MOD = 1_000_000_007L;
        long BASE = 257;

        long patternHash = 0;
        long windowHash = 0;
        long highestPower = 1;

        for (int i = 0; i < m; i++) {

            patternHash = (patternHash * BASE
                    + pattern.charAt(i)) % MOD;

            windowHash = (windowHash * BASE
                    + text.charAt(i)) % MOD;

            if (i < m - 1) {
                highestPower = (highestPower * BASE) % MOD;
            }
        }

        for (int i = 0; i <= n - m; i++) {

            if (patternHash == windowHash &&
                text.regionMatches(i, pattern, 0, m)) {

                return i;
            }

            if (i < n - m) {

                long outgoing =
                        (text.charAt(i) * highestPower) % MOD;

                windowHash = (windowHash - outgoing + MOD) % MOD;

                windowHash = (
                        windowHash * BASE
                        + text.charAt(i + m)
                ) % MOD;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        System.out.println(rabinKarp(text, pattern));

        sc.close();
    }
}