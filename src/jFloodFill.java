import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayDeque;

public class jFloodFill {

    static int[][] floodFill(
            int[][] image,
            int sr,
            int sc,
            int color) {

        int rows = image.length;
        int cols = image[0].length;

        // Remember the original colour
        int oldColor = image[sr][sc];

        // No change needed
        if (oldColor == color) {
            return image;
        }

        // Four possible directions
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        Deque<Integer> stack = new ArrayDeque<>();

        // Change starting pixel
        image[sr][sc] = color;

        // Store starting position
        stack.push(sr * cols + sc);

        while (!stack.isEmpty()) {

            // Remove current pixel
            int current = stack.pop();

            int row = current / cols;
            int col = current % cols;

            // Explore four neighbours
            for (int i = 0; i < 4; i++) {

                int newRow = row + dr[i];
                int newCol = col + dc[i];

                // Check boundaries and original colour
                if (newRow >= 0 && newRow < rows &&
                    newCol >= 0 && newCol < cols &&
                    image[newRow][newCol] == oldColor) {

                    // Change colour immediately
                    image[newRow][newCol] = color;

                    // Add pixel to DFS stack
                    stack.push(newRow * cols + newCol);
                }
            }
        }

        return image;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int rows = sc.nextInt();
        int cols = sc.nextInt();

        int[][] image = new int[rows][cols];

        // Read image
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                image[i][j] = sc.nextInt();
            }
        }

        int sr = sc.nextInt();
        int scol = sc.nextInt();

        int color = sc.nextInt();

        // Perform flood fill
        floodFill(image, sr, scol, color);

        // Print modified image
        for (int i = 0; i < rows; i++) {

            for (int j = 0; j < cols; j++) {

                System.out.print(image[i][j] + " ");
            }

            System.out.println();
        }

        sc.close();
    }
}