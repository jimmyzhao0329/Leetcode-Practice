// https://leetcode.com/problems/additive-number/

public class Solution {
    public boolean isAdditiveNumber(String num) {
        if(num == null || num.length() == 0){
            return false;
        }
        for(int i = 1; i <= num.length() / 2; i++){
            for(int j = 1; j <= (num.length() - i) / 2; j++){
                if( check ( num.substring(0, i), num.substring(i, i + j), num.substring(i + j) ) ){
                    return true;
                }
            }
        }
        return false;
    }
    
    private boolean check(String num1, String num2, String num){
        if(num1.length() > 1 && num1.charAt(0) == '0'
        || num2.length() > 1 && num2.charAt(0) == '0'){
            return false;
        }
        String sum = add(num1, num2);
        if(num.equals(sum)) return true;
        if(num.length() <= sum.length() || !sum.equals(num.substring(0, sum.length())) ) return false;
        else{
            return check(num2, sum, num.substring(sum.length()));
        }
    }
    
    private String add(String num1, String num2){
        StringBuilder sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, carry = 0;
        while(i >= 0 || j >= 0){
            int p1 = (i >= 0 ? num1.charAt(i--) - '0' : 0);
            int p2 = (j >= 0 ? num2.charAt(j--) - '0' : 0);
            int sum = carry + p1 + p2;
            sb.insert(0, sum % 10 + "");
            carry = sum / 10;
        }
        if(carry != 0){
            sb.insert(0, carry + "");
        }
        return sb.toString();
    }
}