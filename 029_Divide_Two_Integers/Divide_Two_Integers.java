//https://leetcode.com/problems/divide-two-integers/

public class Solution {
    public int divide(int dividend, int divisor) {
        if(divisor == 0 || dividend == Integer.MIN_VALUE && divisor == -1){
            return Integer.MAX_VALUE;
        }
        if (dividend != Integer.MIN_VALUE && Math.abs(dividend) < Math.abs(divisor)) {
            return 0;
        }
        if (divisor == Integer.MIN_VALUE){
            return (dividend == Integer.MIN_VALUE) ? 1 : 0;
        }
        long dvd = Math.abs((long)dividend);
        long dvs = Math.abs((long)divisor);
        int sign = ((dividend < 0) ^ (divisor < 0)) ? -1 : 1;
        int res = 0;
        while(dvd >= dvs){
            long temp = dvs;
            int multiple = 1;
            while(dvd >= (temp << 1)){
                temp <<= 1;
                multiple <<= 1;
            }
            res += multiple;
            dvd -= temp;
        }
        return (sign > 0) ? res : -res;
    }
}