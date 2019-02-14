package Array.No_121_Best_Time_to_Buy_and_Sell_Stock;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-14 10:21
 * Description: Best Time to Buy and Sell Stock
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.
 * <p>
 * Note that you cannot sell a stock before you buy one.
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 5
 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
 * Not 7-1 = 6, as selling price needs to be larger than buying price.
 * Example 2:
 * <p>
 * Input: [7,6,4,3,1]
 * Output: 0
 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */


public class Solution {
    //双指针法
    public int maxProfit(int[] prices) {

        int maxProfit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                if (maxProfit < prices[j] - prices[i]) maxProfit = prices[j] - prices[i];
            }
        }

        return maxProfit;
    }


    //浮动判断
    public int maxProfit1(int[] prices) {
        if (prices.length < 2) return 0;

        int temProfit = 0;
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            temProfit = Math.max(temProfit + prices[i] - prices[i - 1], 0); // 赚到的钱加上浮动的钱 与0比较不能为负的
            maxProfit = Math.max(maxProfit, temProfit);
        }

        return maxProfit;
    }


}
