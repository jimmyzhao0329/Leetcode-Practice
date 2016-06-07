// https://leetcode.com/problems/set-matrix-zeroes/

public class Solution {
    public void setZeroes(int[][] matrix) {
        boolean fr = false, fc = false;
        int row = matrix.length;
        int col = matrix[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(matrix[i][j] == 0){
                    if(i == 0){
                        fr = true;
                    }
                    if(j == 0){
                        fc = true;
                    }
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < row; i++){
            for(int j = 1; j < col; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        if(fr == true){
            for(int i = 0; i < col; i++){
                matrix[0][i] = 0;
            }
        }
        if(fc == true){
            for(int i = 0; i < row; i++){
                matrix[i][0] = 0;
            }
        }
    }
}