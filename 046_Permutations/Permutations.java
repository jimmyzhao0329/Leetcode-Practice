//https://leetcode.com/problems/permutations/

public class Solution {
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums){
        if(cur.size() == nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(cur.contains(nums[i])){
                continue;
            }
            cur.add(nums[i]);
            helper(res, cur, nums);
            cur.remove(cur.size() - 1);
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums == null || nums.length == 0){
            return res;
        }
        helper(res, new ArrayList<Integer>(), nums);
        return res;
    }
}