// https://leetcode.com/problems/move-zeroes/

public class Solution {
    public void moveZeroes(int[] nums) {
        if(nums == null || nums.length == 0){
            return;
        }
        int i = 0, j = 0;
        for(; j < nums.length; j++){
            if(nums[j] == 0){
                continue;
            }
            nums[i++] = nums[j];
        }
        while(i < nums.length){
            nums[i++] = 0;
        }
    }
}