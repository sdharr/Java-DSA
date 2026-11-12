import java.util.Scanner;
import java.util.ArrayDeque;
import java.util.Deque;

public class jNumberOfIslands {

    static int numIslands(char[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        int count = 0;

        // Four possible directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Deque<Integer> stack = new ArrayDeque<>();

        for (int r = 0; r < rows; r++) {

            for (int c = 0; c < cols; c++) {

                // Found unvisited land
                if (grid[r][c] == '1') {

                    count++;

                    // Mark immediately to avoid revisiting
                    grid[r][c] = '0';

                    // Convert row and column into one index
                    stack.push(r * cols + c);

                    // Explore the entire island
                    while (!stack.isEmpty()) {

                        int current = stack.pop();

                        int row = current / cols;
                        int col = current % cols;

                        for (int i = 0; i < 4; i++) {

                            int newRow = row + dr[i];
                            int newCol = col + dc[i];

                            if (newRow >= 0 && newRow < rows &&
                                newCol >= 0 && newCol < cols &&
                                grid[newRow][newCol] == '1') {

                                grid[newRow][newCol] = '0';

                                stack.push(
                                    newRow * cols + newCol
                                );
                            }
                        }
                    }
                }
            }
        }

        return count;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        char[][] grid = new char[rows][cols];

        // Read grid
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                grid[i][j] = sc.next().charAt(0);
            }
        }

        System.out.println(numIslands(grid));

        sc.close();
    }
}