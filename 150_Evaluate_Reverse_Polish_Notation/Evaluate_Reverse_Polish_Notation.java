// https://leetcode.com/problems/evaluate-reverse-polish-notation/

public class Solution {
    public int evalRPN(String[] tokens) {
        if(tokens.length == 0){
            return 0;
        }
        int res = 0;
        Stack<Integer> st = new Stack<Integer>();
        for(int i = 0; i < tokens.length; i++){
            if(tokens[i].equals("+")){
                int a = st.pop();
                int b = st.pop();
                st.push(a + b);
            }
            else if(tokens[i].equals("-")){
                int a = st.pop();
                int b = st.pop();
                st.push(b - a);
            }
            else if(tokens[i].equals("*")){
                int a = st.pop();
                int b = st.pop();
                st.push(a * b);
            }
            else if(tokens[i].equals("/")){
                int a = st.pop();
                int b = st.pop();
                st.push(b / a);
            }
            else{
                int temp = Integer.parseInt(tokens[i]);
                st.push(temp);
            }
        }
        return st.pop();
    }
}