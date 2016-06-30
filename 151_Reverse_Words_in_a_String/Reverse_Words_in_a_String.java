// https://leetcode.com/problems/reverse-words-in-a-string/

public class Solution {
    public String reverseWords(String s) {
        String[] temp = s.trim().split(" +");
        Collections.reverse(Arrays.asList(temp));
        return String.join(" ", temp);
    }
}