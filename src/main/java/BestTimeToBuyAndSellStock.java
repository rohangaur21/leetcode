public class BestTimeToBuyAndSellStock {
    public int maxProfit1(int[] prices) {
        int len = prices.length;
        int max = 0;
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (prices[j] - prices[i] > max) {
                    max = prices[j] - prices[i];
                }
            }
        }
        return max > 0 ? max : 0;
    }

    public int maxProfit2(int[] prices) {
        int len = prices.length;
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < len; i++) {
            min = Math.min(min, prices[i]);
            max = Math.max(max, prices[i] - min);
        }
        return max;
    }


    public int maxProfit3(int[] prices) {
        int total = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            if (prices[i + 1] > prices[i]) {
                total += prices[i + 1] - prices[i];
            }
        }
        return total;
    }

    public int maxProfit(int[] prices, int k) {
        int n = prices.length;
        if (n <= 1)
            return 0;

        //if k >= n/2, then you can make maximum number of transactions.
        if (k >= n / 2) {
            int maxPro = 0;
            for (int i = 1; i < n; i++) {
                if (prices[i] > prices[i - 1])
                    maxPro += prices[i] - prices[i - 1];
            }
            return maxPro;
        }

        int[][] dp = new int[k + 1][n];
        for (int i = 1; i <= k; i++) {
            int localMax = dp[i - 1][0] - prices[0];
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.max(dp[i][j - 1], prices[j] + localMax);
                localMax = Math.max(localMax, dp[i - 1][j] - prices[j]);
            }
        }
        return dp[k][n - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock o = new BestTimeToBuyAndSellStock();
        int[] p = new int[]{7, 1, 5, 3, 6, 4};
        System.out.println(o.maxProfit1(p));
        System.out.println(o.maxProfit2(p));
        System.out.println(o.maxProfit3(p));
        System.out.println(o.maxProfit(p, 3));
        System.out.println("__");
        p = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(o.maxProfit1(p));
        System.out.println(o.maxProfit2(p));
        System.out.println(o.maxProfit3(p));
        System.out.println(o.maxProfit(p, 3));
    }
}
