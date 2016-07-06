// https://leetcode.com/problems/factorial-trailing-zeroes/

//all the trailing zeros are made by 5 * 2. Since there will always be ample
//2's, we only need to figure out the number of 5's. n / 5 is the # of 5s. 
//However, numbers like 25 will contribute two 5s. Therefore, we calculate 
//trailingZeroes(n / 5) to get number of 25s, 125s, etc.

public class Solution {
    public int trailingZeroes(int n) {
        if(n <= 0){
            return 0;
        }
        return (n / 5) + trailingZeroes(n / 5);
    }
}