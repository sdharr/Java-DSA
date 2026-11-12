import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class gQueueUsingStack {

    static class MyQueue {

        private final Deque<Integer> input = new ArrayDeque<>();
        private final Deque<Integer> output = new ArrayDeque<>();

        // Insert an element at the back
        public void push(int x) {

            input.push(x);
        }

        // Transfer elements when output stack is empty
        private void transfer() {

            if (output.isEmpty()) {

                while (!input.isEmpty()) {
                    output.push(input.pop());
                }
            }
        }

        // Remove and return the front element
        public int pop() {

            transfer();

            return output.pop();
        }

        // Return the front element
        public int peek() {

            transfer();

            return output.peek();
        }

        // Check whether the queue is empty
        public boolean empty() {

            return input.isEmpty() && output.isEmpty();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MyQueue queue = new MyQueue();

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next();

            switch (command.toUpperCase()) {

                case "PUSH":

                    int x = sc.nextInt();
                    queue.push(x);
                    break;

                case "POP":

                    System.out.println(queue.pop());
                    break;

                case "PEEK":

                    System.out.println(queue.peek());
                    break;

                case "EMPTY":

                    System.out.println(queue.empty());
                    break;
            }
        }

        sc.close();
    }
}