import java.util.Scanner;
import java.util.Arrays;
import java.util.concurrent.ThreadLocalRandom;

public class dQuickSort {

    static void quickSort(int[] arr, int low, int high) {

        while (low < high) {

            int randomIndex = ThreadLocalRandom.current()
                    .nextInt(low, high + 1);

            int pivot = arr[randomIndex];

            int left = low;
            int mid = low;
            int right = high;

            while (mid <= right) {

                if (arr[mid] < pivot) {

                    int temp = arr[left];
                    arr[left] = arr[mid];
                    arr[mid] = temp;

                    left++;
                    mid++;

                } else if (arr[mid] > pivot) {

                    int temp = arr[mid];
                    arr[mid] = arr[right];
                    arr[right] = temp;

                    right--;

                } else {

                    mid++;
                }
            }

            // Recursively sort the smaller partition
            // and iterate over the larger partition.

            if (left - low < high - right) {

                quickSort(arr, low, left - 1);

                low = right + 1;

            } else {

                quickSort(arr, right + 1, high);

                high = left - 1;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        quickSort(arr, 0, n - 1);

        System.out.println(Arrays.toString(arr));

        sc.close();
    }
}