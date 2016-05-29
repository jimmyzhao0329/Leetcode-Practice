//https://leetcode.com/problems/valid-sudoku/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;
        Boolean[] check = new Boolean[9];
        
        //check rows
        for(int i = 0; i < row; i++){
            for(int j = 0; j < 9; j++){
                check[j] = false;
            }
            for(int j = 0; j < col; j++){
                if(board[i][j] >= '1' && board[i][j] <= '9'){
                    if(check[board[i][j] - '1']){
                        return false;
                    }
                    else{
                        check[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
        //check cols
        for(int j = 0; j < col; j++){
            for(int i = 0; i < 9; i++){
                check[i] = false;
            }
            for(int i = 0; i < row; i++){
                if(board[i][j] >= '1' && board[i][j] <= '9'){
                    if(check[board[i][j] - '1']){
                        return false;
                    }
                    else{
                        check[board[i][j] - '1'] = true;
                    }
                }
            }
        }
        
        //check blocks
        for(int i = 0; i < row; i++){
            for(int j = 0; j < 9; j++){
                check[j] = false;
            }
            for(int j = 0; j < col; j++){
                int i2 = (i / 3) * 3 + j / 3;
                int j2 = (i % 3) * 3 + j % 3;
                if(board[i2][j2] >= '1' && board[i2][j2] <= '9'){
                    if(check[board[i2][j2] - '1']){
                        return false;
                    }
                    else{
                        check[board[i2][j2] - '1'] = true;
                    }
                }
            }
        }
        
        return true;
    }
}