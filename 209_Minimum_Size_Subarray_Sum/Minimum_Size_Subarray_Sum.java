// https://leetcode.com/problems/minimum-size-subarray-sum/

public class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int start = 0, end = 0;
        int sum = 0, minLen = Integer.MAX_VALUE;
        while(end < nums.length){
            while(end < nums.length && sum < s){
                sum += nums[end];
                end++;
            }
            if(sum < s){
                break;
            }
            while(start < nums.length && sum >= s){
                sum -= nums[start];
                start++;
            }
            if(end - start + 1 < minLen){
                minLen = end - start + 1;
            }
        }
        return (minLen == Integer.MAX_VALUE) ? 0 : minLen;
    }
}