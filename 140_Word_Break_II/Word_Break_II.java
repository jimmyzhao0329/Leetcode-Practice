// https://leetcode.com/problems/word-break-ii/

public class Solution {
    public List<String> wordBreak(String s, Set<String> wordDict) {
        return helper(s, wordDict, new HashMap<String, List<String>>());
    }
    
    private List<String> helper(String s, Set<String> wordDict, HashMap<String, List<String>> map){
        if(map.containsKey(s)){
            return map.get(s);
        }
        List<String> res = new ArrayList<String>();
        if(s.length() == 0){
            res.add("");
            return res;
        }
        for(String word: wordDict){
            if(s.startsWith(word)){
                List<String> sublist = helper(s.substring(word.length()), wordDict, map);
                for(String sub : sublist){
                    res.add(word + (sub.isEmpty() ? "" : " ") + sub);
                }
            }
        }
        map.put(s, res);
        return res;
    }
}