import java.util.Scanner;

public class dBinarySearchRecursive {

    static int binarySearch(int[] arr, int target, int left, int right) {

        if (left > right) {
            return -1;
        }

        int mid = left + (right - left) / 2;

        if (arr[mid] == target) {
            return mid;
        }

        if (arr[mid] < target) {
            return binarySearch(arr, target, mid + 1, right);
        }

        return binarySearch(arr, target, left, mid - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        int result = binarySearch(arr, target, 0, n - 1);

        System.out.println(result);

        sc.close();
    }
}