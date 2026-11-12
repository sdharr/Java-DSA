import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class eParentheses {

    static void generate(
            int n,
            int open,
            int close,
            StringBuilder current,
            List<String> result) {

        // All parentheses have been placed
        if (current.length() == 2 * n) {
            result.add(current.toString());
            return;
        }

        // Add an opening parenthesis
        if (open < n) {

            current.append('(');

            generate(
                n,
                open + 1,
                close,
                current,
                result
            );

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }

        // Add a closing parenthesis
        if (close < open) {

            current.append(')');

            generate(
                n,
                open,
                close + 1,
                current,
                result
            );

            // Backtrack
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        List<String> result = new ArrayList<>();

        StringBuilder current = new StringBuilder();

        generate(
            n,
            0,
            0,
            current,
            result
        );

        System.out.println(result);

        sc.close();
    }
}
