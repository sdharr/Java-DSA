import java.util.Scanner;

public class bSecondLargest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        boolean found = false;

        for (int i = 0; i < n; i++) {

            if (arr[i] > largest) {

                secondLargest = largest;
                largest = arr[i];

                if (secondLargest != Integer.MIN_VALUE) {
                    found = true;
                }

            } else if (arr[i] < largest && arr[i] > secondLargest) {

                secondLargest = arr[i];
                found = true;
            }
        }

        if (found) {
            System.out.println(secondLargest);
        } else {
            System.out.println("No second-largest element");
        }

        sc.close();
    }
}