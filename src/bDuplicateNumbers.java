import java.util.Scanner;
//Floyd's Cycle Detection Algorithm (Tortoise and Hare)
public class bDuplicateNumbers {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        // Phase 1: Detect the cycle
        int slow = arr[0];
        int fast = arr[0];

        do {
            slow = arr[slow];
            fast = arr[arr[fast]];

        } while (slow != fast);

        // Phase 2: Find the starting point of the cycle
        slow = arr[0];

        while (slow != fast) {
            slow = arr[slow];
            fast = arr[fast];
        }

        System.out.println(slow);

        sc.close();
    }
}
