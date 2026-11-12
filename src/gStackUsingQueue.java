import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class gStackUsingQueue {

    static class MyStack {

        private final Queue<Integer> queue = new ArrayDeque<>();

        // Push an element
        public void push(int x) {

            queue.offer(x);

            int size = queue.size();

            // Move previous elements behind the new element
            for (int i = 0; i < size - 1; i++) {

                queue.offer(queue.poll());
            }
        }

        // Remove and return the top element
        public int pop() {

            return queue.remove();
        }

        // Return the top element
        public int top() {

            return queue.element();
        }

        // Check whether the stack is empty
        public boolean empty() {

            return queue.isEmpty();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyStack stack = new MyStack();

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next();

            switch (command.toUpperCase()) {

                case "PUSH":

                    int x = sc.nextInt();
                    stack.push(x);
                    break;

                case "POP":

                    System.out.println(stack.pop());
                    break;

                case "TOP":

                    System.out.println(stack.top());
                    break;

                case "EMPTY":

                    System.out.println(stack.empty());
                    break;
            }
        }

        sc.close();
    }
}