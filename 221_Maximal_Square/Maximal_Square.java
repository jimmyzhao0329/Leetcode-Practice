//  https://leetcode.com/problems/maximal-square/

public class Solution {
    public int maximalSquare(char[][] m) {
        if(m.length == 0){
            return 0;
        }
        int row = m.length;
        int col = m[0].length;
        int[][] res = new int[row + 1][col + 1];
        int side = 0;
        for(int i = 1; i <= row; i++){
            for(int j = 1; j <= col; j++){
                if(m[i - 1][j - 1] == '1'){
                    res[i][j] = Math.min(Math.min(res[i][j - 1], res[i - 1][j]), res[i - 1][j - 1]) + 1;
                    side = Math.max(side, res[i][j]);
                }
            }
        }
        return side * side;
    }
}