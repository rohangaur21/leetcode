package integer;
public class Knapsack {

    // Method to find the maximum value of the knapsack
    public static int knapsack(int capacity, int[] weights, int[] values, int n) {
        int[][] dp = new int[n + 1][capacity + 1];

        // Build the table dp[][] in bottom-up manner
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= capacity; w++) {
                if (i == 0 || w == 0) {
                    dp[i][w] = 0; // No items or no capacity
                } else if (weights[i - 1] <= w) {
                    dp[i][w] = Math.max(values[i - 1] + dp[i - 1][w - weights[i - 1]], dp[i - 1][w]);
                } else {
                    dp[i][w] = dp[i - 1][w]; // Item is not included
                }
            }
        }

        // The maximum value is at dp[n][capacity]
        return dp[n][capacity];
    }

    public static void main(String[] args) {
        // Hardcoded test case
        int[] weights = {2, 3, 4, 5};  // Weights of items
        int[] values = {3, 4, 5, 6};   // Values of items
        int capacity = 5;              // Knapsack capacity
        int n = weights.length;        // Number of items

        // Call knapsack method
        int maxValue = knapsack(capacity, weights, values, n);

        // Output the result
        System.out.println("Maximum value that can be obtained: " + maxValue);
    }
}
