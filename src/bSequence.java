import java.util.Scanner;
import java.util.HashSet;

public class bSequence {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        HashSet<Integer> set = new HashSet<>();

        for (int num : arr) {
            set.add(num);
        }

        int longest = 0;

        for (int num : set) {

            if (num == Integer.MIN_VALUE || !set.contains(num - 1)) {

                int length = 0;
                long current = num;

                while (current <= Integer.MAX_VALUE &&
                       set.contains((int) current)) {

                    length++;
                    current++;
                }

                longest = Math.max(longest, length);
            }
        }

        System.out.println(longest);

        sc.close();
    }
}
