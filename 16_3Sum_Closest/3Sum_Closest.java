//https://leetcode.com/problems/3sum-closest/

public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length < 3){
            return 0;
        }
        
        int closest = Integer.MAX_VALUE;
        int csum = target;
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 2; i++){
            int j = i + 1, k = len - 1;
            while(j < k){
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == target){
                    return target;
                }
                
                if(closest > Math.abs(target - sum)){
                    closest = Math.abs(target - sum);
                    csum = sum;
                }
                
                if(sum > target){
                    k--;
                } 
                else{
                    j++;
                }
            }
        }
        
        return csum;
    }
}