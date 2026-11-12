import java.util.Scanner;
import java.util.PriorityQueue;

public class iKthLargestUsingHeap {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // Create a Min Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>();

        for (int num : nums) {

            heap.offer(num);

            // Maintain only K largest elements
            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Top element is the Kth largest
        System.out.println(heap.peek());

        sc.close();
    }
}