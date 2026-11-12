import java.util.Scanner;

public class aZero {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long count = 0;

        while (n >= 5) {

            n = n / 5;

            count = count + n;
        }

        System.out.println(count);

        sc.close();
    }
}