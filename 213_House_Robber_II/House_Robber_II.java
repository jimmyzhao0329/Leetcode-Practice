// https://leetcode.com/problems/house-robber-ii/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        if(nums.length == 1){
            return nums[0];
        }
        return Math.max(helper(nums, 0, nums.length - 2), helper(nums, 1, nums.length - 1));
    }
    
    private int helper(int[] nums, int start, int end){
        int[] sum = new int[nums.length];
        sum[0] = 0;
        sum[1] = nums[start];
        for(int i = 2; i < nums.length; i++){
            sum[i] = Math.max(nums[start + i - 1] + sum[i - 2], sum[i - 1]);
        }
        return sum[nums.length - 1];
    } 
}