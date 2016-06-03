// https://leetcode.com/problems/climbing-stairs/

public class Solution {
    public int climbStairs(int n) {
        if(n <= 0){
            return 0;
        }
        if(n == 1){
            return 1;
        }
        if(n == 2){
            return 2;
        }
        int pre1 = 1;
        int pre2 = 2;
        int steps = 0;
        for(int i = 3; i <= n; i++){
            steps = pre1 + pre2;
            pre1 = pre2;
            pre2 = steps;
        }
        return steps;
        
    }
}