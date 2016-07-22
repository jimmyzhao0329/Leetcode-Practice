// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-with-cooldown/

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length <= 1){
            return 0;
        }
        int bi = -prices[0], bPre1 = bi;
        int si = 0, sPre1 = 0, sPre2 = 0;
        for(int i = 1; i < prices.length; i++){
            //bi is the max profit till day i. It's whether keeping the value of buying 
            //at the previous day, or selling before previous day and buying at day i 
            bi = Math.max(sPre2 - prices[i], bPre1);
            //si is the max profit till day i. It's whether keeping the value of selling
            //at the previous day, or buying before day i and selling at day i
            si = Math.max(bPre1 + prices[i], sPre1);
            //update variables
            bPre1 = bi;
            sPre2 = sPre1;
            sPre1 = si;
        }
        return si;
    }
}