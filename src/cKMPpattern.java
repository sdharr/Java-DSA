import java.util.Scanner;
//Given two strings:
//- text: The main string in which we search.
//- pattern: The string we want to find.
//Find the first occurrence index of pattern inside text using the KMP (Knuth-Morris-Pratt) algorithm.

//Return -1 if the pattern does not exist in the text.
public class cKMPpattern {

    static int[] buildLPS(String pattern) {

        int n = pattern.length();

        int[] lps = new int[n];

        int len = 0;
        int i = 1;

        while (i < n) {

            if (pattern.charAt(i) == pattern.charAt(len)) {

                len++;
                lps[i] = len;
                i++;

            } else {

                if (len != 0) {

                    len = lps[len - 1];

                } else {

                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    static int KMPSearch(String text, String pattern) {

        if (pattern.isEmpty()) {
            return 0;
        }

        int[] lps = buildLPS(pattern);

        int i = 0;
        int j = 0;

        while (i < text.length()) {

            if (text.charAt(i) == pattern.charAt(j)) {

                i++;
                j++;
            }

            if (j == pattern.length()) {

                return i - j;

            } else if (i < text.length() &&
                       text.charAt(i) != pattern.charAt(j)) {

                if (j != 0) {

                    j = lps[j - 1];

                } else {

                    i++;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String text = sc.nextLine();
        String pattern = sc.nextLine();

        System.out.println(KMPSearch(text, pattern));

        sc.close();
    }
}