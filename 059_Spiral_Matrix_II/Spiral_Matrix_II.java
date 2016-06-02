// https://leetcode.com/problems/spiral-matrix-ii/

public class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int num = 1;
        int rowUp = 0, rowDown = n - 1;
        int colLeft = 0, colRight = n - 1;
        while(true){
            for(int i = colLeft; i <= colRight; i++ ){
                res[rowUp][i] = num;
                num++;
            }
            rowUp++;
            if(rowUp > rowDown){
                break;
            }
            
            for(int i = rowUp; i <= rowDown; i++){
                res[i][colRight] = num;
                num++;
            }
            colRight--;
            if(colLeft > colRight){
                break;
            }
            
            for(int i = colRight; i >= colLeft; i--){
                res[rowDown][i] = num;
                num++;
            }
            rowDown--;
            if(rowUp > rowDown){
                break;
            }
            
            for(int i = rowDown; i >= rowUp; i--){
                res[i][colLeft] = num;
                num++;
            }
            colLeft++;
            if(colLeft > colRight){
                break;
            }
        }
        
        return res;
    }
}