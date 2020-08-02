/*
 * @lc app=leetcode.cn id=122 lang=java
 *
 * [122] 买卖股票的最佳时机 II
 */

 /*
 *思路：1.贪心法：只要前一天的价格比后一天要低就买入第二天卖出，这样总的
 *利润就是最高的
 *2.峰谷法：计算连续的峰和谷
 *3.暴力法。
 */
// @lc code=start

//贪心法：只要后一天比前一天价格高就计算到利润中。
class Solution {
    public int maxProfit(int[] prices) {
        int income = 0;
        for (int i = 0; i < prices.length - 1; i ++) {
            if (prices[i + 1] > prices[i]) {
                income += prices[i + 1] -prices[i];
            }
        }
        return income;
    }
}
// @lc code=end

//峰谷法
class SolutionOne {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int i =0;
        int vallay = prices[0];
        int peak = prices[0];
        int income = 0;
    
        while (i < prices.length - 1) {
            while (i < prices.length - 1 && prices[i] >= prices[i + 1]) {
                i ++;
            }
            vallay = prices[i];

            while (i < prices.length - 1 && prices[i] <= prices[i + 1]) {
                i ++;
            }
            peak = prices[i];

            income += peak - vallay;
        }
        return income;
    }
}