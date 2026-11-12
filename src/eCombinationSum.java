import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class eCombinationSum {

    static void findCombinations(
            int[] candidates,
            int index,
            int target,
            List<Integer> current,
            List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (candidates[i] > target) {
                break;
            }

            current.add(candidates[i]);

            findCombinations(
                candidates,
                i,
                target - candidates[i],
                current,
                result
            );

            current.remove(current.size() - 1);
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[] candidates = new int[n];

        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        int target = sc.nextInt();

        Arrays.sort(candidates);

        List<List<Integer>> result = new ArrayList<>();

        List<Integer> current = new ArrayList<>();

        findCombinations(
            candidates,
            0,
            target,
            current,
            result
        );

        System.out.println(result);

        sc.close();
    }
}