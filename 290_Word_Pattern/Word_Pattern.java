// https://leetcode.com/problems/word-pattern/

public class Solution {
    public boolean wordPattern(String pattern, String str) {
        String[] sa = str.split(" ");
        if(pattern.length() != sa.length){
            return false;
        }
        Map<Character, String> map = new HashMap<Character, String>();
        for(int i = 0; i < sa.length; i++){
            char c = pattern.charAt(i);
            if(map.containsKey(c)){
                if(!map.get(c).equals(sa[i])){
                    return false;
                }
            }
            else{
                if(map.containsValue(sa[i])){
                    return false;
                }
                map.put(c, sa[i]);
            }
        } 
        return true;
    }
}