import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class dKelement {

    static int quickSelect(int[] arr, int k) {

        int target = arr.length - k;

        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {

            int randomIndex = ThreadLocalRandom.current()
                    .nextInt(left, right + 1);

            int pivot = arr[randomIndex];

            int low = left;
            int mid = left;
            int high = right;

            while (mid <= high) {

                if (arr[mid] < pivot) {

                    int temp = arr[low];
                    arr[low] = arr[mid];
                    arr[mid] = temp;

                    low++;
                    mid++;

                } else if (arr[mid] > pivot) {

                    int temp = arr[mid];
                    arr[mid] = arr[high];
                    arr[high] = temp;

                    high--;

                } else {

                    mid++;
                }
            }

            if (target < low) {

                right = low - 1;

            } else if (target > high) {

                left = high + 1;

            } else {

                return pivot;
            }
        }

        return -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        System.out.println(quickSelect(arr, k));

        sc.close();
    }
}
