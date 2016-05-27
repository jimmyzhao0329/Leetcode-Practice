//https://leetcode.com/problems/remove-element/

public class Solution {
    public int removeElement(int[] nums, int val) {
        int back = nums.length - 1;
        int i = 0;
        while(i <= back){
            if(nums[i] != val){
                i++;
            }
            else{
                nums[i] = nums[back--];
                if(i != 0){
                    i--;
                }
            }
        }
        return i;
    }
}