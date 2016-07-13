// https://leetcode.com/problems/rectangle-area/

public class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int total = (C - A) * (D - B) + (G - E) * (H - F);
        int overLap = 0;
        if(G > A && C > E && H > B && D > F){
            int h = Math.min(C, G) - Math.max(A, E);
            int v = Math.min(D, H) - Math.max(B, F);
            overLap = h * v;
        }
        return total - overLap;
    }
}