import java.util.Scanner;
import java.util.PriorityQueue;
import java.util.Collections;

public class iMedianFromDataStream {

    static class MedianFinder {

        // Max Heap: Stores the smaller half
        private final PriorityQueue<Integer> lower =
                new PriorityQueue<>(Collections.reverseOrder());

        // Min Heap: Stores the larger half
        private final PriorityQueue<Integer> upper =
                new PriorityQueue<>();

        // Add a number to the data stream
        public void addNum(int num) {

            if (lower.isEmpty() || num <= lower.peek()) {
                lower.offer(num);
            } else {
                upper.offer(num);
            }

            // Balance the two heaps
            if (lower.size() > upper.size() + 1) {

                upper.offer(lower.poll());

            } else if (upper.size() > lower.size()) {

                lower.offer(upper.poll());
            }
        }

        // Find the current median
        public double findMedian() {

            if (lower.size() > upper.size()) {
                return lower.peek();
            }

            return ((long) lower.peek() + upper.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        MedianFinder finder = new MedianFinder();

        int operations = sc.nextInt();

        for (int i = 0; i < operations; i++) {

            String command = sc.next().toUpperCase();

            switch (command) {

                case "ADD":

                    int num = sc.nextInt();

                    finder.addNum(num);

                    break;

                case "MEDIAN":

                    System.out.println(finder.findMedian());

                    break;
            }
        }

        sc.close();
    }
}