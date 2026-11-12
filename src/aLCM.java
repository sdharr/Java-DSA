import java.util.Scanner;

public class aLCM {

    static long gcd(long a, long b) {

        while (b != 0) {
            long remainder = a % b;
            a = b;
            b = remainder;
        }

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        long a = sc.nextLong();
        long b = sc.nextLong();

        long lcm;

        if (a == 0 || b == 0) {
            lcm = 0;
        } else {
            lcm = (a / gcd(a, b)) * b;
        }

        System.out.println(lcm);

        sc.close();
    }
}
