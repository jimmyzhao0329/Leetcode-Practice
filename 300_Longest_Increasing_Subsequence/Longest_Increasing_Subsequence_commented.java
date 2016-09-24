// https://leetcode.com/problems/longest-increasing-subsequence/

public class Solution {
    public int lengthOfLIS(int[] nums) {
        if(nums.length <= 1){
            return nums.length;
        }
        // dp数组用来储存到达当前位置的最长增序子序列的长度
        int[] dp = new int[nums.length];
        // 每一点都初始化为1，因为每一点自己都可以形成一个长度为1的子序列
        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;
        }
        // 从头开始更新dp数组
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    if(dp[j] + 1 > dp[i]){
                        dp[i] = dp[j] + 1;
                    }
                }
            }
        }
        int res = 0;
        for(int i = 0; i < nums.length; i++){
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}