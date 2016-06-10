// https://leetcode.com/problems/restore-ip-addresses/

public class Solution {
    
    private boolean checkIP(String s){
        if(s.length() > 1 && s.charAt(0) == '0'){
            return false;
        }
        int num = Integer.valueOf(s);
        if(num < 0 || num > 255){
            return false;
        }
        else{
            return true;
        }
    }
    
    private void helper(List<String> res, List<String> list, String s, int start){
        if(list.size() == 4){
            if(start != s.length()){
                return;
            }
            StringBuilder sb = new StringBuilder();
            for(String temp : list){
                sb.append(temp);
                sb.append('.');
            }
            sb.deleteCharAt(sb.length() - 1);
            res.add(sb.toString());
            return;
        }
        for(int i = start; i < s.length() && i <= start + 3; i++){
            String temp = s.substring(start, i + 1);
            if(checkIP(temp) == true){
                list.add(temp);
                helper(res, list, s, i + 1);
                list.remove(list.size() - 1);
            }
            
        }
    }
    
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<String>();
        List<String> list = new ArrayList<String>();
        if(s.length() < 4 || s.length() > 12){
            return res;
        }
        helper(res, list, s, 0);
        return res;
    }
}