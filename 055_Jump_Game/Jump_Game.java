// https://leetcode.com/problems/jump-game/

public class Solution {
    public boolean canJump(int[] nums) {
        boolean[] can = new boolean[nums.length];
        can[0] = true;
        for(int i = 1; i < nums.length; i++){
            for(int j = i - 1; j >= 0; j--){
                if(can[j] && nums[j] + j >= i){
                    can[i] = true;
                    break;
                }
            }
        }
        
        return can[nums.length - 1];
    }
}