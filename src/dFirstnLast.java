import java.util.Scanner;
import java.util.Arrays;

public class dFirstnLast {

    static int lowerBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    static int upperBound(int[] arr, int target) {

        int left = 0;
        int right = arr.length;

        while (left < right) {

            int mid = left + (right - left) / 2;

            if (arr[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int first = lowerBound(arr, target);

        int last = upperBound(arr, target) - 1;

        if (first == n || arr[first] != target) {

            System.out.println("[-1, -1]");

        } else {

            System.out.println(
                Arrays.toString(new int[]{first, last})
            );
        }

        sc.close();
    }
}