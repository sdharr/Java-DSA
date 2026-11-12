import java.util.Scanner;
import java.util.Arrays;

public class bMerge {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr1 = new int[n];

        for (int i = 0; i < n; i++) {
            arr1[i] = sc.nextInt();
        }

        int m = sc.nextInt();

        int[] arr2 = new int[m];

        for (int i = 0; i < m; i++) {
            arr2[i] = sc.nextInt();
        }

        int[] merged = new int[n + m];

        int i = 0;
        int j = 0;
        int k = 0;

        while (i < n && j < m) {

            if (arr1[i] <= arr2[j]) {
                merged[k] = arr1[i];
                i++;
            } else {
                merged[k] = arr2[j];
                j++;
            }

            k++;
        }

        while (i < n) {
            merged[k] = arr1[i];
            i++;
            k++;
        }

        while (j < m) {
            merged[k] = arr2[j];
            j++;
            k++;
        }

        System.out.println(Arrays.toString(merged));

        sc.close();
    }
}