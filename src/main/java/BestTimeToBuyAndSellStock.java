public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {

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
}
