// https://leetcode.com/problems/subsets/

public class Solution {
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int start){
        res.add(new ArrayList<Integer>(cur));
        if(cur.size() == nums.length){
            return;
        }
        for(int i = start; i < nums.length; i++){
            cur.add(nums[i]);
            helper(res, cur, nums, i + 1);
            cur.remove(cur.size() - 1);
        }
        
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
}