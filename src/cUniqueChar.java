import java.util.Scanner;

public class cUniqueChar {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int[] frequency = new int[26];

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            frequency[ch - 'a']++;
        }

        int result = -1;

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (frequency[ch - 'a'] == 1) {

                result = i;
                break;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
