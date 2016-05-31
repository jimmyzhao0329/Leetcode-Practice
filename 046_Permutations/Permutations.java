//https://leetcode.com/problems/permutations/

public class Solution {
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int[] nums, int start){
        for(int i = 0; i < nums.length; i++){
            cur.add(nums[i]);
        }
        res.add(new ArrayList<Integer>(cur));
        
        for(int i = start; i < nums.length - 1; i++){
            for(int j = i + 1; j < nums.length; j++){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                helper(res, new ArrayList<Integer>(), nums, i + 1);
                temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
    
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), nums, 0);
        return res;
    }
}