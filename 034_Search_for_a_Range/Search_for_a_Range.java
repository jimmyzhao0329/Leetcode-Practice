//https://leetcode.com/problems/search-for-a-range/

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = {-1, -1};
        int l = 0, r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] < target){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        if(nums[l] == target){
            res[0] = l;
        }
        else if(nums[r] == target){
            res[0] = r;
        }
        else{
            return res;
        }
        
        l = 0;
        r = r = nums.length - 1;
        while(l + 1 < r){
            int mid = l + (r - l) / 2;
            if(nums[mid] > target){
                r = mid;
            }
            else{
                l = mid;
            }
        }
        if(nums[r] == target){
            res[1] = r;
        }
        else if(nums[l] == target){
            res[1] = l;
        }
        
        return res;
    }
}