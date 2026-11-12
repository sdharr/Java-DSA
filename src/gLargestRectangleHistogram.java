import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class gLargestRectangleHistogram {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] heights = new int[n];

        for (int i = 0; i < n; i++) {
            heights[i] = sc.nextInt();
        }

        Deque<Integer> stack = new ArrayDeque<>();

        long maxArea = 0;

        for (int i = 0; i <= n; i++) {

            int currentHeight = (i == n) ? 0 : heights[i];

            while (!stack.isEmpty() &&
                   heights[stack.peek()] > currentHeight) {

                int height = heights[stack.pop()];

                int leftBoundary = stack.isEmpty()
                        ? -1
                        : stack.peek();

                int width = i - leftBoundary - 1;

                long area = (long) height * width;

                maxArea = Math.max(maxArea, area);
            }

            stack.push(i);
        }

        System.out.println(maxArea);

        sc.close();
    }
}