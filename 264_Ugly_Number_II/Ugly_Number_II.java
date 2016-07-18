// https://leetcode.com/problems/ugly-number-ii/

public class Solution {
    public int nthUglyNumber(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index1 = 0, index2 = 0, index3 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i = 1; i < n; i++){
            int temp = Math.min(factor2, Math.min(factor3, factor5));
            ugly[i] = temp;
            if(temp == factor2){
                factor2 = ugly[++index1] * 2;
            }
            if(temp == factor3){
                factor3 = ugly[++index2] * 3;
            }
            if(temp == factor5){
                factor5 = ugly[++index3] * 5;
            }
        }
        return ugly[n - 1];
    }
}