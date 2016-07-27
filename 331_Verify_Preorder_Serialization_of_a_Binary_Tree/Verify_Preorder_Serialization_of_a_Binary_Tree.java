// https://leetcode.com/problems/verify-preorder-serialization-of-a-binary-tree/

public class Solution {
    public boolean isValidSerialization(String preorder) {
        if(preorder == null || preorder.length() == 0){
            return false;
        }
        String[] pre = preorder.split(",");
        Stack<String> st = new Stack<String>();
        for(String s : pre){
            while(s.equals("#") && !st.isEmpty() && st.peek().equals("#")){
                st.pop();
                if(st.isEmpty()) return false;
                st.pop();
            }
            st.push(s);
        }
        return st.size() == 1 && st.peek().equals("#");
    }
}