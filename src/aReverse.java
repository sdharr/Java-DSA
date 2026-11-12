import java.util.Scanner;
//Reverse 32 bit integer
public class aReverse {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long reversed = 0;

        while (n != 0) {

            int digit = n % 10;

            reversed = reversed * 10 + digit;

            n = n / 10;
        }

        if (reversed < Integer.MIN_VALUE ||
            reversed > Integer.MAX_VALUE) {

            System.out.println(0);

        } else {

            System.out.println((int) reversed);
        }

        sc.close();
    }
}