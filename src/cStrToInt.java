import java.util.Scanner;

public class cStrToInt {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();

        int i = 0;
        int n = str.length();

        // Skip leading whitespace
        while (i < n && Character.isWhitespace(str.charAt(i))) {
            i++;
        }

        // Read the sign
        int sign = 1;

        if (i < n && (str.charAt(i) == '+' || str.charAt(i) == '-')) {

            if (str.charAt(i) == '-') {
                sign = -1;
            }

            i++;
        }

        long limit = (sign == 1)
                ? Integer.MAX_VALUE
                : -(long) Integer.MIN_VALUE;

        long result = 0;

        // Read digits
        while (i < n &&
               str.charAt(i) >= '0' &&
               str.charAt(i) <= '9') {

            int digit = str.charAt(i) - '0';

            // Check overflow before multiplication
            if (result > (limit - digit) / 10) {

                System.out.println(
                    sign == 1
                        ? Integer.MAX_VALUE
                        : Integer.MIN_VALUE
                );

                sc.close();
                return;
            }

            result = result * 10 + digit;

            i++;
        }

        System.out.println(result * sign);

        sc.close();
    }
}
