//https://leetcode.com/problems/letter-combinations-of-a-phone-number/

public class Solution {
    
    private String[] letters = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    private void helper(String digits, List<String> res, int start, String cur){
        if(start == digits.length()){
            res.add(cur);
            return;
        }
        
        String temp = letters[digits.charAt(start) - '0'];
        for(int j = 0; j < temp.length(); j++ ){
            cur += temp.charAt(j);
            helper(digits, res, start + 1, cur);
            cur = cur.substring(0, cur.length() - 1);
        }
    }
    
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<String>();
        if(digits == "" || digits.length() == 0){
            return res;
        }
        helper(digits, res, 0, "");
        return res;
    }
}