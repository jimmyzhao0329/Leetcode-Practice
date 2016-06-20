// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/

public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            res += (prices[i] - prices[i - 1] > 0) ? (prices[i] - prices[i - 1]) : 0;
        }
        return res;
    }
}