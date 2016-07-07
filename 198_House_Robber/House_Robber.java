// https://leetcode.com/problems/house-robber/

public class Solution {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0){
            return 0;
        }
        int[] money = new int[nums.length + 1];
        money[0] = 0;
        money[1] = nums[0];
        for(int i = 2; i <= nums.length; i++){
            money[i] = Math.max(nums[i - 1] + money[i - 2], money[i - 1]);
        }
        return money[nums.length];
    }
}