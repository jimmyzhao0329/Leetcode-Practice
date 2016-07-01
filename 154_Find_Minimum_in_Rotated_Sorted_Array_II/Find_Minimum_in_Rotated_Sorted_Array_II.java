// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/

public class Solution {
    public int findMin(int[] nums) {
        int left = 0, right = nums.length - 1;
        while(left + 1 < right){
            int mid = left + (right - left) / 2;
            if(nums[mid] < nums[right]){
                right = mid;
            }
            else if(nums[mid] > nums[right]){
                left = mid;
            }
            else{
                right--;
            }
        }
        return (nums[left] < nums[right]) ? nums[left] : nums[right];
    }
}