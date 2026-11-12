import java.util.Scanner;

public class cStringComp {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        StringBuilder compressed = new StringBuilder();

        for (int i = 0; i < str.length();) {

            int j = i + 1;

            while (j < str.length() &&
                   str.charAt(j) == str.charAt(i)) {

                j++;
            }

            int count = j - i;

            compressed.append(str.charAt(i));
            compressed.append(count);

            i = j;
        }

        String result;

        if (compressed.length() < str.length()) {
            result = compressed.toString();
        } else {
            result = str;
        }

        System.out.println(result);

        sc.close();
    }
}
