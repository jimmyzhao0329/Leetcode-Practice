//https://leetcode.com/problems/combination-sum-ii/

public class Solution {
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int target, int cur_sum, int start){
        if(cur_sum == target){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i < nums.length && cur_sum + nums[i] <= target; i++){
            if(i != start && nums[i] == nums[i - 1]){
                continue;
            }
            else{
                cur.add(nums[i]);
                helper(res, cur, nums, target, cur_sum + nums[i], i + 1);
                cur.remove(cur.size() - 1);
            }
        }
        
    }
    
    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, target, 0, 0);
        return res;
    }
}