import java.util.Scanner;

public class bMajorityElement {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int candidate = arr[0];
        int count = 0;

        // Boyer-Moore Voting Algorithm
        for (int i = 0; i < n; i++) {

            if (count == 0) {
                candidate = arr[i];
            }

            if (arr[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Verify whether the candidate is a majority element
        count = 0;

        for (int i = 0; i < n; i++) {

            if (arr[i] == candidate) {
                count++;
            }
        }

        if (count > n / 2) {
            System.out.println(candidate);
        } else {
            System.out.println("No majority element");
        }

        sc.close();
    }
}
