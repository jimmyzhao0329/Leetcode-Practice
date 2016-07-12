// https://leetcode.com/problems/combination-sum-iii/

public class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), k, n, 1, 0);
        return res;
    }
    
    private void helper(List<List<Integer>> res, List<Integer> cur, int k, int n, int start, int sum){
        if(cur.size() == k && sum == n){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i <= 9; i++){
            cur.add(i);
            helper(res, cur, k, n, i + 1, sum + i);
            cur.remove(cur.size() - 1);
        }
    }
}