//https://leetcode.com/problems/4sum/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int len = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < len - 3; i++){
            if(i != 0 && nums[i] == nums[i - 1]){
                continue;
            }
            if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                break;
            }
            if(nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target){
                continue;
            }
            for(int j = i + 1; j < len - 2; j++){
                if(j != i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int l = j + 1, r = len - 1;
                while(l < r){
                    if(l != j + 1 && nums[l] == nums[l - 1]){
                        l++;
                        continue;
                    }
                    if(r != len - 1 && nums[r] == nums[r + 1]){
                        r--;
                        continue;
                    }
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        List<Integer> temp = new ArrayList<Integer>(Arrays.asList(nums[i], nums[j], nums[l++], nums[r--]));
                        res.add(temp);
                        
                    }
                    else if(sum < target){
                        l++;
                    }
                    else{
                        r--;
                    }
                }
                
            }
        }
        
        return res;
    }
}