// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

public class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int len = prices.length;
        if(len == 0){
            return res;
        }
        int maxByFar = prices[len - 1];
        for(int i = len - 2; i >= 0; i--){
            maxByFar = (maxByFar > prices[i]) ? maxByFar: prices[i];
            res = ((maxByFar - prices[i]) > res) ? (maxByFar - prices[i]) : res;
        }
        return res;
    }
}