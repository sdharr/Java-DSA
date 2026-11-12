import java.util.Scanner;

public class gCircularQueue {

    static class CircularQueue {

        private final int[] arr;

        private int front;
        private int rear;
        private int size;

        CircularQueue(int capacity) {

            arr = new int[capacity];

            front = 0;
            rear = -1;
            size = 0;
        }

        // Insert an element
        public boolean enQueue(int value) {

            if (isFull()) {
                return false;
            }

            rear = (rear + 1) % arr.length;

            arr[rear] = value;

            size++;

            return true;
        }

        // Remove the front element
        public boolean deQueue() {

            if (isEmpty()) {
                return false;
            }

            front = (front + 1) % arr.length;

            size--;

            return true;
        }

        // Return the front element
        public int Front() {

            if (isEmpty()) {
                return -1;
            }

            return arr[front];
        }

        // Return the rear element
        public int Rear() {

            if (isEmpty()) {
                return -1;
            }

            return arr[rear];
        }

        // Check whether queue is empty
        public boolean isEmpty() {

            return size == 0;
        }

        // Check whether queue is full
        public boolean isFull() {

            return size == arr.length;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int capacity = sc.nextInt();

        CircularQueue queue = new CircularQueue(capacity);

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next().toUpperCase();

            switch (command) {

                case "ENQUEUE":

                    int value = sc.nextInt();

                    System.out.println(queue.enQueue(value));
                    break;

                case "DEQUEUE":

                    System.out.println(queue.deQueue());
                    break;

                case "FRONT":

                    System.out.println(queue.Front());
                    break;

                case "REAR":

                    System.out.println(queue.Rear());
                    break;

                case "ISEMPTY":

                    System.out.println(queue.isEmpty());
                    break;

                case "ISFULL":

                    System.out.println(queue.isFull());
                    break;
            }
        }

        sc.close();
    }
}