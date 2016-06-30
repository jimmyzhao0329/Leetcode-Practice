// https://leetcode.com/problems/maximum-product-subarray/

public class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int maxcur = nums[0];
        int mincur = nums[0];
        int res = nums[0];
        int maxbefore = maxcur, minbefore = mincur;
        for(int i = 1; i < nums.length; i++){
            maxcur = Math.max(nums[i], Math.max(nums[i] * maxbefore, nums[i] * minbefore));
            mincur = Math.min(nums[i], Math.min(nums[i] * maxbefore, nums[i] * minbefore));
            res = Math.max(res, maxcur);
            maxbefore = maxcur;
            minbefore = mincur;
        }
        return res;
    }
}