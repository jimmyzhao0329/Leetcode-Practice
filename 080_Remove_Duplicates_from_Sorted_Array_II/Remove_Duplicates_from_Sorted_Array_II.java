// https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/

public class Solution {
    public int removeDuplicates(int[] nums) {
        int flag = 0;
        int count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == nums[i - 1]){
                if(flag == 0){
                    flag = 1;
                    nums[count++] = nums[i];
                }
                else{
                    continue;
                }
            }
            else{
                nums[count++] = nums[i];
                flag = 0;
            }
        }
        return count;
    }
}