import java.util.Scanner;

public class cRemoveDuplicate {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        boolean[] seen = new boolean[128];

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < str.length(); i++) {

            char ch = str.charAt(i);

            if (!seen[ch]) {

                result.append(ch);

                seen[ch] = true;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
