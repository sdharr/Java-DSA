import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class gReversePolishNotation {

    static int evaluateRPN(String[] tokens) {

        Deque<Integer> stack = new ArrayDeque<>();

        for (String token : tokens) {

            if (token.equals("+") ||
                token.equals("-") ||
                token.equals("*") ||
                token.equals("/")) {

                int b = stack.pop();
                int a = stack.pop();

                int result = 0;

                switch (token) {

                    case "+":
                        result = a + b;
                        break;

                    case "-":
                        result = a - b;
                        break;

                    case "*":
                        result = a * b;
                        break;

                    case "/":
                        result = a / b;
                        break;
                }

                stack.push(result);

            } else {

                stack.push(Integer.parseInt(token));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] tokens = new String[n];

        for (int i = 0; i < n; i++) {
            tokens[i] = sc.next();
        }

        System.out.println(evaluateRPN(tokens));

        sc.close();
    }
}
