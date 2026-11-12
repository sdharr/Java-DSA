import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class ePhoneNumber {

    static String[] mapping = {
        "", "", "abc", "def",
        "ghi", "jkl", "mno",
        "pqrs", "tuv", "wxyz"
    };

    static void generateCombinations(
            String digits,
            int index,
            StringBuilder current,
            List<String> result) {

        if (index == digits.length()) {
            result.add(current.toString());
            return;
        }

        int digit = digits.charAt(index) - '0';

        String letters = mapping[digit];

        for (int i = 0; i < letters.length(); i++) {

            current.append(letters.charAt(i));

            generateCombinations(
                digits,
                index + 1,
                current,
                result
            );

            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String digits = sc.next();

        List<String> result = new ArrayList<>();

        generateCombinations(
            digits,
            0,
            new StringBuilder(),
            result
        );

        System.out.println(result);

        sc.close();
    }
}