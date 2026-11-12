import java.util.Scanner;

public class eSudokuSolver {

    static boolean isValid(
            char[][] board,
            int row,
            int col,
            int num) {

        char digit = (char) (num + '0');

        // Check row and column
        for (int i = 0; i < 9; i++) {

            if (board[row][i] == digit ||
                board[i][col] == digit) {

                return false;
            }
        }

        // Find starting position of 3x3 box
        int startRow = (row / 3) * 3;
        int startCol = (col / 3) * 3;

        // Check 3x3 box
        for (int i = startRow; i < startRow + 3; i++) {

            for (int j = startCol; j < startCol + 3; j++) {

                if (board[i][j] == digit) {
                    return false;
                }
            }
        }

        return true;
    }

    static boolean solveSudoku(char[][] board) {

        for (int row = 0; row < 9; row++) {

            for (int col = 0; col < 9; col++) {

                // Find an empty cell
                if (board[row][col] == '0') {

                    // Try digits 1 to 9
                    for (int num = 1; num <= 9; num++) {

                        if (isValid(board, row, col, num)) {

                            board[row][col] = (char) (num + '0');

                            if (solveSudoku(board)) {
                                return true;
                            }

                            // Backtrack
                            board[row][col] = '0';
                        }
                    }

                    // No valid digit found
                    return false;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        char[][] board = new char[9][9];

        for (int i = 0; i < 9; i++) {

            for (int j = 0; j < 9; j++) {

                board[i][j] = sc.next().charAt(0);
            }
        }

        if (solveSudoku(board)) {

            for (int i = 0; i < 9; i++) {

                for (int j = 0; j < 9; j++) {

                    System.out.print(board[i][j] + " ");
                }

                System.out.println();
            }

        } else {

            System.out.println("No solution");
        }

        sc.close();
    }
}