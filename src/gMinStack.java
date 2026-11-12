import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class gMinStack {

    static class MinStack {

        private final Deque<Integer> values = new ArrayDeque<>();
        private final Deque<Integer> mins = new ArrayDeque<>();

        // Push an element
        public void push(int x) {

            values.push(x);

            if (mins.isEmpty() || x <= mins.peek()) {
                mins.push(x);
            }
        }

        // Remove the top element
        public void pop() {

            int removed = values.pop();

            if (removed == mins.peek()) {
                mins.pop();
            }
        }

        // Return the top element
        public int top() {

            return values.peek();
        }

        // Return the minimum element
        public int getMin() {

            return mins.peek();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MinStack stack = new MinStack();

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next();

            switch (command.toUpperCase()) {

                case "PUSH":

                    int x = sc.nextInt();
                    stack.push(x);
                    break;

                case "POP":

                    stack.pop();
                    break;

                case "TOP":

                    System.out.println(stack.top());
                    break;

                case "GETMIN":

                    System.out.println(stack.getMin());
                    break;
            }
        }

        sc.close();
    }
}