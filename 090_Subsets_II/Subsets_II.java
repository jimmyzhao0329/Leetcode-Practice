// https://leetcode.com/problems/subsets-ii/

public class Solution {
    private void helper(List<List<Integer>> res, List<Integer> cur, int start, int[] nums){
        res.add(new ArrayList<Integer>(cur));
        if(cur.size() == nums.length){
            return;
        }
        for(int i = start; i < nums.length; i++){
            if(i != start && nums[i - 1] == nums[i]){
                continue;
            }
            cur.add(nums[i]);
            helper(res, cur, i + 1, nums);
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), 0, nums);
        return res;
    }
}