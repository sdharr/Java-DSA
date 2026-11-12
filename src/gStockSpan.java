import java.util.Scanner;
import java.util.Arrays;
import java.util.Deque;
import java.util.ArrayDeque;

public class gStockSpan {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] prices = new int[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextInt();
        }

        int[] span = new int[n];

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {

            // Remove previous days with prices
            // less than or equal to today's price
            while (!stack.isEmpty() &&
                   prices[stack.peek()] <= prices[i]) {

                stack.pop();
            }

            // Calculate stock span
            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                span[i] = i - stack.peek();
            }

            // Store current day's index
            stack.push(i);
        }

        System.out.println(Arrays.toString(span));

        sc.close();
    }
}