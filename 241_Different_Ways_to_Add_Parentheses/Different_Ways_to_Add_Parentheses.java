// https://leetcode.com/problems/different-ways-to-add-parentheses/

public class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new ArrayList<Integer>();
        if(input == null || input.length() == 0){
            return res;
        }
        for(int i = 0; i < input.length(); i++){
            char c = input.charAt(i);
            if(c == '+' || c == '-' || c == '*'){
                String p1 = input.substring(0, i);
                String p2 = input.substring(i + 1);
                List<Integer> res1 = diffWaysToCompute(p1);
                List<Integer> res2 = diffWaysToCompute(p2);
                for(int val1 : res1){
                    for(int val2 : res2){
                        if(c == '+'){
                            res.add(val1 + val2);
                        }
                        else if(c == '-'){
                            res.add(val1 - val2);
                        }
                        else if(c == '*'){
                            res.add(val1 * val2);
                        }
                    }
                }
            }
        }
        if(res.size() == 0){
            res.add(Integer.valueOf(input));
        }
        return res;
    }
}