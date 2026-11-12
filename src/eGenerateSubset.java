import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class eGenerateSubset {

    static void generateSubsets(
            int[] arr,
            int index,
            List<Integer> current,
            List<List<Integer>> result) {

        if (index == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        // Exclude the current element
        generateSubsets(arr, index + 1, current, result);

        // Include the current element
        current.add(arr[index]);

        generateSubsets(arr, index + 1, current, result);

        current.remove(current.size() - 1);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        generateSubsets(arr, 0, current, result);

        System.out.println(result);

        sc.close();
    }
}