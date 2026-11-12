
import java.util.*;

public class kLongestIncreasingSubsequence {

    public static int lengthOfLIS(int[] nums) {

        int n = nums.length;

        int[] tails = new int[n];

        int size = 0;

        for (int num : nums) {

            int left = 0;
            int right = size;

            // Find the first element >= num
            while (left < right) {

                int mid = left + (right - left) / 2;

                if (tails[mid] < num) {
                    left = mid + 1;
                } else {
                    right = mid;
                }
            }

            // Place num at its correct position
            tails[left] = num;

            // Extend the LIS length if needed
            if (left == size) {
                size++;
            }
        }

        return size;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        System.out.println(lengthOfLIS(nums));

        sc.close();
    }
}
