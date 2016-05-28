//https://leetcode.com/problems/search-insert-position/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums.length == 0){
            return 0;
        }
        
        int l = 0, r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] == target){
                return mid;
            }
            else if(nums[mid] < target){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        if(nums[l] >= target){
            return l;
        }
        else if(nums[r] >= target){
            return r;
        }
        else{
            return r + 1;
        }
    }
}