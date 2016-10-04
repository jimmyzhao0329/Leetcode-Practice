//https://leetcode.com/problems/3sum/

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return res;
        }
        
        int len = nums.length;
        Arrays.sort(nums);
        
        for(int i = 0; i < len - 2; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            
            int j = i + 1, k = len - 1;
            while(j < k){
                if(j != i + 1 && nums[j] == nums[j - 1]){
                    j++;
                    continue;
                }
                if(k != len - 1 && nums[k] == nums[k + 1]){
                    k--;
                    continue;
                }
                int sum = nums[i] + nums[j] + nums[k];
                if(sum == 0){
                    List<Integer> temp = Arrays.asList(nums[i],nums[j++],nums[k--]);
                    res.add(temp);
                }
                else if(sum < 0){
                    j++;
                }
                else{
                    k--;
                }
            }
        }
        
        return res;
    }
}