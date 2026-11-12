import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class bSubarraySumK {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] arr = new long[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        long k = sc.nextLong();

        Map<Long, Long> map = new HashMap<>();

        map.put(0L, 1L);

        long prefixSum = 0;
        long count = 0;

        for (int i = 0; i < n; i++) {

            prefixSum += arr[i];

            long required = prefixSum - k;

            count += map.getOrDefault(required, 0L);

            map.put(
                prefixSum,
                map.getOrDefault(prefixSum, 0L) + 1
            );
        }

        System.out.println(count);

        sc.close();
    }
}
