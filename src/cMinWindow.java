import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class cMinWindow {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();
        String t = sc.nextLine();

        if (t.isEmpty() || s.length() < t.length()) {
            System.out.println("");
            sc.close();
            return;
        }

        Map<Character, Integer> need = new HashMap<>();

        for (char ch : t.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }

        int missing = t.length();

        int left = 0;
        int minLength = Integer.MAX_VALUE;
        int startIndex = 0;

        for (int right = 0; right < s.length(); right++) {

            char ch = s.charAt(right);

            if (need.getOrDefault(ch, 0) > 0) {
                missing--;
            }

            need.put(ch, need.getOrDefault(ch, 0) - 1);

            while (missing == 0) {

                int currentLength = right - left + 1;

                if (currentLength < minLength) {

                    minLength = currentLength;
                    startIndex = left;
                }

                char leftChar = s.charAt(left);

                need.put(
                    leftChar,
                    need.getOrDefault(leftChar, 0) + 1
                );

                if (need.get(leftChar) > 0) {
                    missing++;
                }

                left++;
            }
        }

        if (minLength == Integer.MAX_VALUE) {
            System.out.println("");
        } else {
            System.out.println(
                s.substring(startIndex, startIndex + minLength)
            );
        }

        sc.close();
    }
}