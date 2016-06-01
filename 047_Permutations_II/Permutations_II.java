//https://leetcode.com/problems/permutations-ii/

public class Solution {
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int[] used){
        if(cur.size() == nums.length){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(used[i] == 1){
                continue;
            }
            if(i != 0 && nums[i] == nums[i - 1] && used[i - 1] == 1){
                continue;
            }
            used[i] = 1;
            cur.add(nums[i]);
            helper(res, cur, nums, used);
            cur.remove(cur.size() - 1);
            used[i] = 0;
        }
    }
    
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        int[] used = new int[nums.length];
        Arrays.sort(nums);
        helper(res, new ArrayList<Integer>(), nums, used);
        return res;
    }
}