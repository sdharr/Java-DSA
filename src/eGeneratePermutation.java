import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class eGeneratePermutation {

    static void generatePermutations(
            int[] arr,
            boolean[] used,
            List<Integer> current,
            List<List<Integer>> result) {

        if (current.size() == arr.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < arr.length; i++) {

            if (!used[i]) {

                used[i] = true;
                current.add(arr[i]);

                generatePermutations(arr, used, current, result);

                current.remove(current.size() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean[] used = new boolean[n];

        List<Integer> current = new ArrayList<>();

        List<List<Integer>> result = new ArrayList<>();

        generatePermutations(arr, used, current, result);

        System.out.println(result);

        sc.close();
    }
}
