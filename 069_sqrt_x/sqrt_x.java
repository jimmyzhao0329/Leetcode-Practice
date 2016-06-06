// https://leetcode.com/problems/sqrtx/

public class Solution {
    public int mySqrt(int x) {
        if(x <= 0){
            return 0;
        }
        if(x == 1){
            return 1;
        }
        long l = 1, r = x;
        while(l + 1 < r){
            long mid = l + (r - l) / 2;
            long temp = mid * mid;
            if(temp == x){
                return (int)mid;
            }
            if(temp < x){
                l = mid;
            }
            else{
                r = mid;
            }
        }
        return (int)l;
    }
}