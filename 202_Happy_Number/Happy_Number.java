// https://leetcode.com/problems/happy-number/

public class Solution {
    public boolean isHappy(int n) {
        if(n <= 0){
            return false;
        }
        Set<Integer> set = new HashSet<Integer>();
        while(set.add(n)){
            int res = 0;
            while(n > 0){
                int lastDigit = n % 10;
                res += lastDigit * lastDigit;
                n /= 10;
            }
            if(res == 1){
                return true;
            }
            else{
                n = res;
            }
        }
        return false;
    }

}