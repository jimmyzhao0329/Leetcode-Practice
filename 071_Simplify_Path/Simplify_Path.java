// https://leetcode.com/problems/simplify-path/

public class Solution {
    public String simplifyPath(String path) {
        if(path == null || path.length() == 0){
            return "/";
        }
        Stack<String> st = new Stack<String>();
        for(String s : path.split("/")){
            if(s.equals("..") && !st.isEmpty()){
                st.pop();
            }
            else if(!s.equals("") && !s.equals(".") && !s.equals("..")){
                st.push(s);
            }
        }
        StringBuilder sb = new StringBuilder();
        while(!st.isEmpty()){
            String s = st.pop();
            sb.insert(0, s);
            sb.insert(0, "/");
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}