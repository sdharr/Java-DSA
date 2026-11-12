
import java.util.*;

public class kActivitySelection {

    public static int maxActivities(int[][] activities) {

        int n = activities.length;

        if (n == 0) {
            return 0;
        }

        // Sort activities by ending time
        Arrays.sort(activities, (a, b) ->
            Integer.compare(a[1], b[1])
        );

        int count = 0;

        int lastEnd = 0;

        for (int i = 0; i < n; i++) {

            int start = activities[i][0];
            int end = activities[i][1];

            // Select the activity if it does not overlap
            if (count == 0 || start >= lastEnd) {

                count++;

                lastEnd = end;
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] activities = new int[n][2];

        for (int i = 0; i < n; i++) {

            activities[i][0] = sc.nextInt();
            activities[i][1] = sc.nextInt();
        }

        System.out.println(maxActivities(activities));

        sc.close();
    }
}
