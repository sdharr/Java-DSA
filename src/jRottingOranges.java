import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class jRottingOranges {

    static int orangesRotting(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        Queue<int[]> queue = new ArrayDeque<>();

        int fresh = 0;
        int minutes = 0;

        // Step 1: Find all rotten and fresh oranges
        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                if (grid[r][c] == 2) {

                    queue.offer(new int[]{r, c});

                } else if (grid[r][c] == 1) {

                    fresh++;
                }
            }
        }

        // No fresh oranges
        if (fresh == 0) {
            return 0;
        }

        // Four possible directions
        int[] dr = {1, -1, 0, 0};
        int[] dc = {0, 0, 1, -1};

        // Step 2: Perform multi-source BFS
        while (!queue.isEmpty() && fresh > 0) {

            int size = queue.size();

            minutes++;

            // Process all oranges rotten at the start
            // of this minute
            for (int i = 0; i < size; i++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];

                // Explore four neighbours
                for (int d = 0; d < 4; d++) {

                    int newRow = row + dr[d];
                    int newCol = col + dc[d];

                    if (newRow >= 0 && newRow < rows &&
                        newCol >= 0 && newCol < cols &&
                        grid[newRow][newCol] == 1) {

                        // Make fresh orange rotten
                        grid[newRow][newCol] = 2;

                        fresh--;

                        // Add newly rotten orange
                        queue.offer(new int[]{newRow, newCol});
                    }
                }
            }
        }

        // Step 3: Check whether fresh oranges remain
        return fresh == 0 ? minutes : -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] grid = new int[rows][cols];

        // Read grid
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                grid[i][j] = sc.nextInt();
            }
        }

        System.out.println(orangesRotting(grid));

        sc.close();
    }
}