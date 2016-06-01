// https://leetcode.com/problems/maximum-subarray/

public class Solution {
    public int maxSubArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int cur_sum = 0;
        for(int i = 0; i < nums.length; i++){
            cur_sum += nums[i];
            max = Math.max(max, cur_sum);
            if(cur_sum < 0){
                cur_sum = 0;
            }
        }
        return max;
    }
}