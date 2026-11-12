import java.util.Scanner;

public class aPrimeAlgo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.err.println("Enter N: ");
        int n = sc.nextInt();

        boolean[] isPrime = new boolean[n + 1];

        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i * i <= n; i++) {

            if (isPrime[i]) {

                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        boolean found = false;

        for (int i = 2; i <= n; i++) {

            if (isPrime[i]) {
                System.out.print(i + " ");
                found = true;
            }
        }

        if (!found) {
            System.out.println("No prime numbers");
        }

        sc.close();
    }
}