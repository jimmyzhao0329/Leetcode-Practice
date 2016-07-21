// https://leetcode.com/problems/bulls-and-cows/

public class Solution {
    public String getHint(String secret, String guess) {
        int countA = 0, countB = 0;
        int[] map = new int[10];
        for(int i = 0; i < secret.length(); i++){
            if(secret.charAt(i) == guess.charAt(i)){
                countA++;
            }
            map[secret.charAt(i) - '0']++;
        }
        for(int i = 0; i < guess.length(); i++){
            if(map[guess.charAt(i) - '0'] != 0){
                map[guess.charAt(i) - '0']--;
                countB++;
            }
        }
        countB -= countA;
        String res = countA + "A" + countB + "B";
        return res;
    }
}