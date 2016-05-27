//https://leetcode.com/problems/remove-duplicates-from-sorted-array/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0){
            return 0;
        }
        
        int p = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[i-1]){
                nums[p++] = nums[i];
            }
            else{
                continue;
            }
        }
        return p;
    }
}