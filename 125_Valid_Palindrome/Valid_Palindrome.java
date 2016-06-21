// https://leetcode.com/problems/valid-palindrome/

public class Solution {
    public boolean isPalindrome(String s) {
        if(s.isEmpty()){
            return true;
        }
        for(int i = 0, j = s.length() - 1; i <= j; i++, j--){
            while(i < j && !Character.isLetterOrDigit(s.charAt(i))){
                i++;
            }
            while(i < j && !Character.isLetterOrDigit(s.charAt(j))){
                j--;
            }
            if(Character.toUpperCase(s.charAt(i)) != Character.toUpperCase(s.charAt(j))){
                return false;
            }
        }
        return true;
    }
}