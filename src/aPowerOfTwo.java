import java.util.Scanner;

public class aPowerOfTwo {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        if (n > 0 && (n & (n - 1)) == 0) {
            System.out.println("Power of Two");
        } else {
            System.out.println("Not a Power of Two");
        }

        sc.close();
    }
}
