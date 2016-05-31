//https://leetcode.com/problems/multiply-strings/

public class Solution {
    public String multiply(String num1, String num2) {
        if(num1 == "" || num2 == "" || num1 == "0" || num2 == "0"){
            return "0";
        }
        
        int len1 = num1.length();
        int len2 = num2.length();
        int[] res = new int[len1 + len2];
        for(int i = len1 - 1; i >= 0; i--){
            int n1 = num1.charAt(i) - '0';
            int carry = 0;
            for(int j = len2 - 1; j >= 0; j--){
                int n2 = num2.charAt(j) - '0';
                int mul = n1 * n2 + carry + res[i + j + 1];
                res[i + j + 1] = mul % 10;
                carry = mul / 10;
            }
            res[i] = res[i] + carry;
        }
        
        int i = 0;
        for(; i < res.length; i++){
            if(res[i] != 0){
                break;
            }
        }
        if(i == res.length){
            return "0";
        }
        else{
            StringBuilder result = new StringBuilder();
            for(; i < res.length; i++){
                result.append(res[i]);
            }
            return result.toString();
        }
        
    }
}