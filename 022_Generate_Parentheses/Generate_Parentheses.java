//https://leetcode.com/problems/generate-parentheses/

public class Solution {
    public void helper(List<String> res, String cur, int n, int l, int r){
        if(r == n){
            res.add(cur);
            return;
        }
        if(l < n){
            helper(res, cur + '(', n, l + 1, r);
        }
        if(r < l){
            helper(res, cur + ')', n, l, r + 1);
        }
    }
    
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        helper(res, "", n, 0, 0);
        return res;
    }
}