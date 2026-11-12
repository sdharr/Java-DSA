import java.util.Scanner;

public class bSellStock {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        long[] prices = new long[n];

        for (int i = 0; i < n; i++) {
            prices[i] = sc.nextLong();
        }

        long minPrice = prices[0];
        long maxProfit = 0;

        for (int i = 1; i < n; i++) {

            long profit = prices[i] - minPrice;

            maxProfit = Math.max(maxProfit, profit);

            minPrice = Math.min(minPrice, prices[i]);
        }

        System.out.println(maxProfit);

        sc.close();
    }
}
