import java.util.Scanner;

public class aFastExpo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        int n = sc.nextInt();

        long result = 1;

        while (n > 0) {

            if ((n & 1) == 1) {
                result = result * a;
            }

            n = n / 2;

            if (n > 0) {
                a = a * a;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
