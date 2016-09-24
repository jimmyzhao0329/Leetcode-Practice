// https://leetcode.com/problems/expression-add-operators/

public class Solution {
    public List<String> addOperators(String num, int target) {
        List<String> res = new ArrayList<String>();
        if(num == null || num.length() == 0){
            return res;
        }
        helper(res, "", num, target, 0, 0, 0);
        return res;
    }
    
    private void helper(List<String> res, String path, String num, int target, int index, long total, long mul){
        if(index == num.length()){
            if(total == target){
                res.add(path);
                return;
            }
        }
        for(int i = index; i < num.length(); i++){
            if(i != index && num.charAt(index) == '0') {
                break;
            }
            long cur = Long.parseLong(num.substring(index, i + 1));
            if(index == 0){
                helper(res, path + cur, num, target, i + 1, cur, cur);
            }
            else{
                helper(res, path + '+' + cur, num, target, i + 1, total + cur, cur);
                helper(res, path + '-' + cur, num, target, i + 1, total - cur, -cur);
                helper(res, path + '*' + cur, num, target, i + 1, total - mul + mul * cur, mul * cur);
            }
        }
    }
}