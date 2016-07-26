// https://leetcode.com/problems/bulb-switcher/

public class Solution {
    public int bulbSwitch(int n) {
        /* traditional algorithm
        int[] val = new int[n + 1];
        for(int i = 1; i <= n; i++){  // n rounds
            int temp = i;
            while(temp <= n){
                val[temp - 1] ^= 1;
                temp += i;
            }
        }
        int count = 0;
        for(int i = 0; i < n; i++){
            if(val[i] == 1){
                count++;
            }
        }
        return count;
        */
        
        //math solution
        //Bulb i is switched in round d if and only if d divides i. 
        //So bulb i ends up on if and only if it has an odd number of divisors.
        //Divisors come in pairs, except when i is a square
        //So we count the square numbers within [1, n]
        //sqrt(n) is the largest square number.
        //therefore, totally sqrt(n) square numbers
        return (int)Math.sqrt(n);


    }
}