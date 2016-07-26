// https://leetcode.com/problems/maximum-product-of-word-lengths/

public class Solution {
    public int maxProduct(String[] words) {
        int len = words.length;
        if(len == 0){
            return len;
        }
        int[] val = new int[len];
        for(int i = 0; i < len; i++){
            String temp = words[i];
            for(int j = 0; j < temp.length(); j++){
                val[i] = val[i] | (1 << (temp.charAt(j)));
            }
        }
        int res = 0;
        for(int i = 0; i < len; i++){
            for(int j = i + 1; j < len; j++){
                if((val[i] & val[j]) == 0 && words[i].length() * words[j].length() > res){
                    res = words[i].length() * words[j].length();
                }
            }
        }
        return res;
    }
}