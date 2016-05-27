public class Solution {
    
    public String longestPalindrome(String s) {
        
        int longest = 0;
        int start = 0;
        for(int i = 0; i < s.length(); ){
            int left = i;
            int right = i;
            
            while(left >= 0 && s.charAt(left) == s.charAt(i)){
                left--;
            }
            while(right < s.length() && s.charAt(right) == s.charAt(i)){
                right++;
            }
            if(right > i){
                i = right;
            }
            else{
                i++;
            }
            
            while(left >= 0 && right < s.length()){
                if(s.charAt(left) == s.charAt(right)){
                    left--;
                    right++;
                }
                else break;
            }
            
            int len = right - left - 1;
            if(len > longest){
                longest = len;
                start = left + 1;
            }
        }
        
        return s.substring(start, start + longest);
    }
}