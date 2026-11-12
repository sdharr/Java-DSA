
import java.util.*;

public class jCourseSchedule {

    public static boolean canFinish(int numCourses, int[][] prerequisites) {

        List<List<Integer>> adj = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            adj.add(new ArrayList<>());
        }

        int[] indegree = new int[numCourses];

        // Build graph
        for (int[] pair : prerequisites) {
            int course = pair[0];
            int prerequisite = pair[1];

            adj.get(prerequisite).add(course);
            indegree[course]++;
        }

        Queue<Integer> queue = new ArrayDeque<>();

        // Courses with no prerequisites
        for (int i = 0; i < numCourses; i++) {
            if (indegree[i] == 0) {
                queue.offer(i);
            }
        }

        int completed = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();
            completed++;

            for (int next : adj.get(current)) {
                indegree[next]--;

                if (indegree[next] == 0) {
                    queue.offer(next);
                }
            }
        }

        return completed == numCourses;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numCourses = sc.nextInt();
        int m = sc.nextInt();

        int[][] prerequisites = new int[m][2];

        for (int i = 0; i < m; i++) {
            prerequisites[i][0] = sc.nextInt();
            prerequisites[i][1] = sc.nextInt();
        }

        System.out.println(canFinish(numCourses, prerequisites));

        sc.close();
    }
}
