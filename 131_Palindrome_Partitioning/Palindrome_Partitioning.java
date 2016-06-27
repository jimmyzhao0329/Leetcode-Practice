// https://leetcode.com/problems/palindrome-partitioning/

public class Solution {
    private boolean checkPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start++) != s.charAt(end--)){
                return false;
            }
        }    
        return true;
    }
    
    private void helper(String s, List<List<String>> res, List<String> cur, int start){
        if(start == s.length()){
            res.add(new ArrayList<String>(cur));
            return;
        }
        for(int i = start; i < s.length(); i++){
            if(checkPalindrome(s, start, i)){
                cur.add(s.substring(start, i + 1));
                helper(s, res, cur, i + 1);
                cur.remove(cur.size() - 1);
            }
        }
    }
    
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<List<String>>();
        if(s == null || s.length() == 0){
            return res;
        }
        helper(s, res, new ArrayList<String>(), 0);
        return res;
    }
}