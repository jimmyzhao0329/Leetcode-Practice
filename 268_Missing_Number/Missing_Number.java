// https://leetcode.com/problems/missing-number/

public class Solution {
    public int missingNumber(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        int sum = 0;
        int sumC = 0;
        for(int i = 0; i < nums.length; i++){
            sum += nums[i];
            sumC += i;
        }
        return nums.length - (sum - sumC);
    }
}