import java.util.Scanner;

public class dIntSquRoot {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long left = 0;
        long right = n;

        long result = 0;

        while (left <= right) {

            long mid = left + (right - left) / 2;

            if (mid * mid <= n) {

                result = mid;
                left = mid + 1;

            } else {

                right = mid - 1;
            }
        }

        System.out.println(result);

        sc.close();
    }
}
