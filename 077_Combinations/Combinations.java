// https://leetcode.com/problems/combinations/

public class Solution {
    private void helper(List<List<Integer>> res, List<Integer> cur, int start, int n, int k){
        if(cur.size() == k){
            res.add(new ArrayList<Integer>(cur));
            return;
        }
        for(int i = start; i <= n; i++){
            cur.add(i);
            helper(res, cur, i + 1, n, k);
            cur.remove(cur.size() - 1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        helper(res, new ArrayList<Integer>(), 1, n, k);
        return res;
    }
}