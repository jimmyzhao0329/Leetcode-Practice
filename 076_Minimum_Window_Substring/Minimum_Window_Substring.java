// https://leetcode.com/problems/minimum-window-substring/

public class Solution {
    public String minWindow(String s, String t) {
        if(s == null || s.length() == 0 || t == null || t.length() == 0){
            return "";
        }
        
        //Use HashMap to store the letters in string t
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for(char c : t.toCharArray()){
            if(map.containsKey(c)){
                map.put(c, map.get(c) + 1 );
            }
            else{
                map.put(c, 1);
            }
        }
        
        int start = 0, minLen = s.length() + 1, count = 0, resStart = 0;
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                map.put(s.charAt(i), map.get(s.charAt(i)) - 1 );
                if(map.get(s.charAt(i)) >= 0){
                    count++;
                }
                while(count >= t.length()){
                    if(map.containsKey(s.charAt(start))){
                        map.put(s.charAt(start), map.get(s.charAt(start)) + 1 );
                        
                        if(map.get(s.charAt(start)) > 0){
                            int tempLen = i - start + 1;
                            if(tempLen < minLen){
                                minLen = tempLen;
                                resStart = start;
                            }
                            count--;
                        }
                    }
                    start++;
                }
            }
        }
        
        return (minLen == s.length() + 1) ? "" : s.substring(resStart, resStart + minLen);
    }
}