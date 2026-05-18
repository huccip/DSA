package leetcode.easy;

/**
 * <h1><a href="https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/" target="_blank">Problem 8 | Best Time to Buy and Sell Stock</a></h1>
 * <br>
 * You are given an array prices where prices[i] is the price of a given stock on the ith day.
 * <br>
 * You want to maximize your profit by choosing a single day to buy one stock and choosing a different day in the future to sell that stock.
 * <br>
 * Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
 *
 * <br><br>
 *
 * <h1><u>Follow-up:</u></h1>
 * <br>
 * N/A
 *
 * <br><br>
 *
 * <h1><u>Optimization:</u></h1>
 * <br>
 * N/A
 *
 */

class P8Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for (int price : prices) {
            minPrice = Math.min(minPrice, price);

            maxProfit = Math.max(maxProfit, price - minPrice);
        }

        return maxProfit;
    }
}

public class P8BestTimeToBuyAndSellStock {
    public static void main(String[] args) {
        P8Solution s = new P8Solution();
        int[] prices = {7,1,5,3,6,4};
        System.out.println(s.maxProfit(prices));
    }
}
