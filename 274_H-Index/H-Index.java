// https://leetcode.com/problems/h-index/

public class Solution {
    public int hIndex(int[] c) {
        if(c == null || c.length == 0){
            return 0;
        }
        int[] nums = new int[c.length + 1];
        for(int v : c){
            if(v > c.length){
                nums[c.length]++;
            }
            else{
                nums[v]++;
            }
        }
        int total = 0;
        for(int i = c.length; i >= 0; i--){
            total = total + nums[i];
            if(total >= i){
                return i;
            }
        }
        return 0;
    }
}