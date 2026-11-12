import java.util.Scanner;

public class bContainer {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] height = new int[n];

        for (int i = 0; i < n; i++) {
            height[i] = sc.nextInt();
        }

        int left = 0;
        int right = n - 1;

        long maxArea = 0;

        while (left < right) {

            int width = right - left;

            int minHeight = Math.min(
                height[left],
                height[right]
            );

            long area = (long) minHeight * width;

            maxArea = Math.max(maxArea, area);

            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }

        System.out.println(maxArea);

        sc.close();
    }
}