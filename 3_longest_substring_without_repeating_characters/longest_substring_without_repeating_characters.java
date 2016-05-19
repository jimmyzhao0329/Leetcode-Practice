//instead of using hash map, use index[128] will save even more time


public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() <= 1){
            return s.length();
        }
        
        Map<Character, Integer> map = new HashMap<>();
        int startptr = 0, count = 0, maxCount = 1;
        
        for(int i = 0; i < s.length(); i++){
            if(map.containsKey(s.charAt(i))){
                startptr = Math.max(map.get(s.charAt(i)) + 1, startptr);
            }
            count = i - startptr + 1;
            maxCount = Math.max(maxCount, count);
            map.put(s.charAt(i), i);
        }
        
        return maxCount;
    }
}