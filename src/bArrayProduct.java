import java.util.Scanner;
import java.util.Arrays;

public class bArrayProduct {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int[] answer = new int[n];

        int prefix = 1;

        for (int i = 0; i < n; i++) {

            answer[i] = prefix;

            prefix = prefix * nums[i];
        }

        int suffix = 1;

        for (int i = n - 1; i >= 0; i--) {

            answer[i] = answer[i] * suffix;

            suffix = suffix * nums[i];
        }

        System.out.println(Arrays.toString(answer));

        sc.close();
    }
}
