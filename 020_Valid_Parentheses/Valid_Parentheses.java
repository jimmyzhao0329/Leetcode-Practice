//https://leetcode.com/problems/valid-parentheses/

public class Solution {
    public boolean isValid(String s) {
        if(s.length() % 2 != 0){
            return false;
        }
        
        Stack<Character> st = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c == '(' || c == '[' || c == '{'){
                st.push(c);
            }
            else if(st.empty()){
                return false;
            }
            else{
                if(c == ')' && st.peek() == '('){
                    st.pop();
                }
                else if(c == ']' && st.peek() == '['){
                    st.pop();
                }
                else if(c == '}' && st.peek() == '{'){
                    st.pop();
                }
                else{
                    return false;
                }
            }
        }
        
        return st.empty();
    }
}