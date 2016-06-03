// https://leetcode.com/problems/add-binary/

public class Solution {
    public String addBinary(String a, String b) {
        if(a == ""){
            return b;
        }
        if(b == ""){
            return a;
        }
        
        int lena = a.length();
        int lenb = b.length();
        int carry = 0;
        int i = lena - 1;
        int j = lenb - 1;
        StringBuilder res = new StringBuilder();
        
        while(i >= 0 || j >= 0){
            int na = 0;
            int nb = 0;
            if(i >= 0){
                na = a.charAt(i) - '0';
            }
            if(j >= 0){
                nb = b.charAt(j) - '0';
            }
            int temp = na + nb + carry;
            res.insert(0, Integer.toString(temp % 2));
            carry = temp / 2;
            i--;
            j--;
        }
        if(carry == 1){
            res.insert(0, "1");
        }
        return res.toString();
        
    }
}