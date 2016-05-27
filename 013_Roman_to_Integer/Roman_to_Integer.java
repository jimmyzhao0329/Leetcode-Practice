//https://leetcode.com/problems/roman-to-integer/

public class Solution {
    public int romanToInt(String s) {
        Map<Character, Integer> roman = new HashMap<Character, Integer>();
        roman.put('M', 1000);
        roman.put('D', 500);
        roman.put('C', 100);
        roman.put('L', 50);
        roman.put('X', 10);
        roman.put('V', 5);
        roman.put('I', 1);
        
        int res = 0;
        int previous = 0;
        for(int i = s.length() - 1; i >= 0; i--){
            int current = roman.get(s.charAt(i));
            if(current < previous){
                res -= current;
            }
            else{
                res += current;
            }
            previous = current;
        }
        
        return res;
        
    }
}