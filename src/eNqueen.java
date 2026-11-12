import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class eNqueen {

    static void solve(
            int row,
            int n,
            char[][] board,
            boolean[] columns,
            boolean[] diagonal1,
            boolean[] diagonal2,
            List<List<String>> result) {

        if (row == n) {

            List<String> solution = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                solution.add(new String(board[i]));
            }

            result.add(solution);
            return;
        }

        for (int col = 0; col < n; col++) {

            int d1 = row - col + n - 1;
            int d2 = row + col;

            if (columns[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            board[row][col] = 'Q';

            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            solve(
                row + 1,
                n,
                board,
                columns,
                diagonal1,
                diagonal2,
                result
            );

            board[row][col] = '.';

            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        char[][] board = new char[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(board[i], '.');
        }

        boolean[] columns = new boolean[n];

        boolean[] diagonal1 = new boolean[2 * n - 1];

        boolean[] diagonal2 = new boolean[2 * n - 1];

        List<List<String>> result = new ArrayList<>();

        solve(
            0,
            n,
            board,
            columns,
            diagonal1,
            diagonal2,
            result
        );

        System.out.println(result.size());

        for (List<String> solution : result) {
            System.out.println(solution);
        }

        sc.close();
    }
}