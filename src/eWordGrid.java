import java.util.Scanner;

public class eWordGrid {

    static boolean search(
            char[][] board,
            String word,
            int row,
            int col,
            int index,
            boolean[][] visited) {

        // Entire word found
        if (index == word.length()) {
            return true;
        }

        // Check boundaries and validity
        if (row < 0 || row >= board.length ||
            col < 0 || col >= board[0].length ||
            visited[row][col] ||
            board[row][col] != word.charAt(index)) {

            return false;
        }

        visited[row][col] = true;

        // Explore four directions
        boolean found =
                search(board, word, row + 1, col, index + 1, visited) ||
                search(board, word, row - 1, col, index + 1, visited) ||
                search(board, word, row, col + 1, index + 1, visited) ||
                search(board, word, row, col - 1, index + 1, visited);

        // Backtrack
        visited[row][col] = false;

        return found;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int m = sc.nextInt();
        int n = sc.nextInt();

        char[][] board = new char[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = sc.next().charAt(0);
            }
        }

        String word = sc.next();

        boolean[][] visited = new boolean[m][n];

        boolean found = false;

        for (int i = 0; i < m && !found; i++) {

            for (int j = 0; j < n && !found; j++) {

                if (board[i][j] == word.charAt(0)) {

                    found = search(
                        board,
                        word,
                        i,
                        j,
                        0,
                        visited
                    );
                }
            }
        }

        System.out.println(found);

        sc.close();
    }
}