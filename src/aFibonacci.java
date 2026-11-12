import java.util.Scanner;

public class aFibonacci {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long a = 0;
        long b = 1;

        if (n == 0) {

            System.out.println(a);

        } else {

            for (int i = 2; i <= n; i++) {

                long next = a + b;

                a = b;
                b = next;
            }

            System.out.println(b);
        }

        sc.close();
    }
}
