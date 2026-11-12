import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;

public class bLeader {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        ArrayList<Integer> leaders = new ArrayList<>();

        int maxRight = Integer.MIN_VALUE;

        for (int i = n - 1; i >= 0; i--) {

            if (arr[i] > maxRight) {

                leaders.add(arr[i]);

                maxRight = arr[i];
            }
        }

        Collections.reverse(leaders);

        System.out.println(leaders);

        sc.close();
    }
}