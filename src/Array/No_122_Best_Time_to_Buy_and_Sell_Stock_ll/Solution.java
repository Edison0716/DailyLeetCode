package Array.No_122_Best_Time_to_Buy_and_Sell_Stock_ll;


/**
 * FileName: Solution
 * Author:   EdisonLi的家用MacBook Pro
 * Date:     2019-02-16 07:38
 * Description: Best Time to Buy and Sell Stock II
 * <p>
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * <p>
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like (i.e., buy one and sell one share of the stock multiple times).
 * <p>
 * Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).
 * <p>
 * Example 1:
 * <p>
 * Input: [7,1,5,3,6,4]
 * Output: 7
 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
 * Example 2:
 * <p>
 * Input: [1,2,3,4,5]
 * Output: 4
 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 * engaging multiple transactions at the same time. You must sell before buying again.
 * Example 3:
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
            int tem = 0;
            for (int j = i + 1; j < prices.length; j++) {
                tem = prices[j] - prices[i];
                if (tem > 0)  maxProfit = maxProfit + tem; break;
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
            temProfit  = Math.max( prices[i] - prices[i - 1], 0); // 赚到的钱加上浮动的钱 与0比较不能为负的
            maxProfit += temProfit;
        }

        return maxProfit;
    }
}
