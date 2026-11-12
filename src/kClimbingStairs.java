
import java.util.*;

public class kClimbingStairs {

    public static int climbStairs(int n) {

        if (n <= 1) {
            return 1;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 2; i <= n; i++) {

            int current = prev1 + prev2;

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        System.out.println(climbStairs(n));

        sc.close();
    }
}

