import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class eRatInMaze {

    static void findPaths(
            int[][] maze,
            boolean[][] visited,
            int row,
            int col,
            int n,
            StringBuilder path,
            List<String> result) {

        // Destination reached
        if (row == n - 1 && col == n - 1) {
            result.add(path.toString());
            return;
        }

        // Mark current cell as visited
        visited[row][col] = true;

        // Directions: Down, Left, Right, Up
        int[] dr = {1, 0, 0, -1};
        int[] dc = {0, -1, 1, 0};

        char[] direction = {'D', 'L', 'R', 'U'};

        for (int i = 0; i < 4; i++) {

            int newRow = row + dr[i];
            int newCol = col + dc[i];

            if (newRow >= 0 && newRow < n &&
                newCol >= 0 && newCol < n &&
                maze[newRow][newCol] == 1 &&
                !visited[newRow][newCol]) {

                path.append(direction[i]);

                findPaths(
                    maze,
                    visited,
                    newRow,
                    newCol,
                    n,
                    path,
                    result
                );

                // Backtrack
                path.deleteCharAt(path.length() - 1);
            }
        }

        // Unmark current cell
        visited[row][col] = false;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        int[][] maze = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                maze[i][j] = sc.nextInt();
            }
        }

        List<String> result = new ArrayList<>();

        if (maze[0][0] == 1 && maze[n - 1][n - 1] == 1) {

            boolean[][] visited = new boolean[n][n];

            findPaths(
                maze,
                visited,
                0,
                0,
                n,
                new StringBuilder(),
                result
            );
        }

        if (result.isEmpty()) {

            System.out.println("-1");

        } else {

            System.out.println(result.size());

            for (String path : result) {
                System.out.println(
                    path.isEmpty() ? "\"\"" : path
                );
            }
        }

        sc.close();
    }
}
