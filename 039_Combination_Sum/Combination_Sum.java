//https://leetcode.com/problems/combination-sum/

public class Solution {
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int cur_sum, int target, int start){
        if(cur_sum > target){
            return;
        }
        if(cur_sum == target){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i < nums.length && cur_sum + nums[i] <= target; i++){
            cur.add(nums[i]);
            helper(res, cur, nums, cur_sum + nums[i], target, i);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> cur = new ArrayList<Integer>();
        Arrays.sort(candidates);
        helper(res, cur, candidates, 0, target, 0);
        return res;
    }
}