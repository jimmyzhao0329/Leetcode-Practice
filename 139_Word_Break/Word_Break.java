// https://leetcode.com/problems/word-break/

public class Solution {
    public boolean wordBreak(String s, Set<String> wordDict) {
        if(wordDict.isEmpty()){
            return false;
        }
        boolean[] res = new boolean[s.length() + 1];
        res[0] = true;
        for(int i = 1; i <= s.length(); i++){
            res[i] = false;
            for(int j = i - 1; j >= 0; j--){
                if(res[j]){
                    String temp = s.substring(j, i);
                    if(wordDict.contains(temp)){
                        res[i] = true;
                        break;
                    }
                }
            }
        }
        return res[s.length()];
    }
}