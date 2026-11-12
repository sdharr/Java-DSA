import java.util.Scanner;

public class bMissingNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int missing = n;

        for (int i = 0; i < n; i++) {

            missing = missing ^ i ^ arr[i];

        }

        System.out.println(missing);

        sc.close();
    }
}