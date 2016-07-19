// https://leetcode.com/problems/perfect-squares/

public class Solution {
    public int numSquares(int n) {
        if(n <= 0){
            return 0;
        }
        int[] dp = new int[n + 1];
        for(int i = 0; i <= n; i++){
            dp[i] = Integer.MAX_VALUE;
        }
        for(int i = 1; i <= n; i++){
            int sqrt = (int)Math.sqrt(i);
            if(sqrt * sqrt == i){
                dp[i] = 1;
                continue;
            }
            for(int j = 1; j <= sqrt; j++){
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        return dp[n];
    }
}