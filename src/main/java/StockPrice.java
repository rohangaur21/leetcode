
    import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

/*
n elements in a stock array
You can buy and sell only once. Only one transaction(Buy and Sell) is allowed.
selling is only possible after buying
Requirement: Maximize the profit

M,T,W,T,F,S


[7,1,5,3,6,4]

[7,6,4,3,1,2]

*/public class StockPrice {

        public static void main(String args[] ) throws Exception {
            int[] stockPrices = {7,1,5,3,6,4};
            int[] stockPrices2 = {7,6,4,3,1,2};
            int[] stockPrices3 = {7,6};

            System.out.println("Max Profits :"+ getProfits(null));

            System.out.println("Max Profits :"+ getProfits(stockPrices2));

            System.out.println("Max Profits :"+ getProfits(stockPrices3));


        }

        public static int getProfits(int[] prices ){
            if(prices == null || prices.length<2){
                return 0;
            }

            int buyMin = Integer.MAX_VALUE;
            int sellMax = Integer.MIN_VALUE;
            int profit =Integer.MIN_VALUE;
            for(int i=0; i<prices.length -1; i++){
                buyMin = Math.min(buyMin, prices[i]);
                for(int j=i+1; j<prices.length -1; j++){
                    sellMax = Math.max(sellMax, prices[j+1]);

                }

                profit = Math.max(profit, sellMax - buyMin);
            }
            return profit;
        }

}
