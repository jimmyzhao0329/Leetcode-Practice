// https://leetcode.com/problems/minimum-size-subarray-sum/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE, sum = 0;
        while(right < nums.length){
            sum += nums[right];
            
            while(sum >= s){
                minLen = Math.min(minLen, right - left + 1);
                sum -= nums[left++];
            }
            
            right++;
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}