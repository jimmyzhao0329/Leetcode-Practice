//https://leetcode.com/problems/container-with-most-water/

public class Solution {
    public int maxArea(int[] height) {
        int vol = 0, maxVol = 0;
        int l = 0, r = height.length - 1;
        while(l < r){
            vol = Math.min(height[l], height[r]) * (r - l);
            maxVol = Math.max(maxVol, vol);
            if(height[l] < height[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return maxVol;
    }
}
