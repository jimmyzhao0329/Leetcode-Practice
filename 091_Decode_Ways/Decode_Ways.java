// https://leetcode.com/problems/decode-ways/

public class Solution {
    public int numDecodings(String s) {
        int len = s.length();
        if(len == 0 || s.charAt(0) <= '0' || s.charAt(0) > '9'){
            return 0;
        }
        int[] res = new int[len + 1];
        res[0] = 1;
        res[1] = 1;
        for(int i = 2; i <= len; i++){
            if(s.charAt(i - 1) > '0' && s.charAt(i - 1) <= '9'){
                res[i] += res[i - 1];
            }
            if(s.charAt(i - 2) == '1' 
                || s.charAt(i - 2) == '2' && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '6'){
                    res[i] += res[i - 2];
                }
        }
        return res[len];
    }
}