import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;

public class bTwoSum {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            long complement = (long) target - nums[i];

            if (complement >= Integer.MIN_VALUE &&
                complement <= Integer.MAX_VALUE &&
                map.containsKey((int) complement)) {

                System.out.println(
                    Arrays.toString(
                        new int[]{map.get((int) complement), i}
                    )
                );

                sc.close();
                return;
            }

            map.put(nums[i], i);
        }

        System.out.println("No solution found");

        sc.close();
    }
}