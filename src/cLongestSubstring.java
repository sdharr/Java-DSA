import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class cLongestSubstring {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        Map<Character, Integer> lastSeen = new HashMap<>();

        int left = 0;
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {

            char ch = str.charAt(right);

            if (lastSeen.containsKey(ch)) {
                left = Math.max(left, lastSeen.get(ch) + 1);
            }

            lastSeen.put(ch, right);

            int currentLength = right - left + 1;

            maxLength = Math.max(maxLength, currentLength);
        }

        System.out.println(maxLength);

        sc.close();
    }
}
