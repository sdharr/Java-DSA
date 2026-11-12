import java.util.Scanner;

public class aPalindrome {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int original = n;
        long reversed = 0;

        if (n < 0) {

            System.out.println("Not Palindrome");

        } else {

            while (n != 0) {

                int digit = n % 10;

                reversed = reversed * 10 + digit;

                n = n / 10;
            }

            if (original == reversed) {
                System.out.println("Palindrome");
            } else {
                System.out.println("Not Palindrome");
            }
        }

        sc.close();
    }
}
