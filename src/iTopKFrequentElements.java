import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.ArrayList;
import java.util.List;

public class iTopKFrequentElements {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] nums = new int[n];

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        int k = sc.nextInt();

        // Step 1: Count frequency of each element
        Map<Integer, Integer> frequency = new HashMap<>();

        for (int num : nums) {

            frequency.put(
                num,
                frequency.getOrDefault(num, 0) + 1
            );
        }

        // Step 2: Create a Min Heap
        PriorityQueue<Integer> heap = new PriorityQueue<>(
            (a, b) -> {

                int freqA = frequency.get(a);
                int freqB = frequency.get(b);

                if (freqA != freqB) {
                    return Integer.compare(freqA, freqB);
                }

                // Larger value is considered worse in a tie
                return Integer.compare(b, a);
            }
        );

        // Step 3: Keep only K most frequent elements
        for (int num : frequency.keySet()) {

            heap.offer(num);

            if (heap.size() > k) {
                heap.poll();
            }
        }

        // Step 4: Collect selected elements
        List<Integer> result = new ArrayList<>();

        while (!heap.isEmpty()) {
            result.add(heap.poll());
        }

        // Step 5: Arrange by frequency descending,
        // and value ascending when frequencies tie
        result.sort((a, b) -> {

            int freqA = frequency.get(a);
            int freqB = frequency.get(b);

            if (freqA != freqB) {
                return Integer.compare(freqB, freqA);
            }

            return Integer.compare(a, b);
        });

        System.out.println(result);

        sc.close();
    }
}