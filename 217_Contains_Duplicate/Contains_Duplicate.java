// https://leetcode.com/problems/contains-duplicate/

public class Solution {
    public boolean containsDuplicate(int[] nums) {
        if(nums == null || nums.length == 0){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        for(int val : nums){
            if(set.contains(val)){
                return true;
            }
            set.add(val);
        }
        return false;
    }
}