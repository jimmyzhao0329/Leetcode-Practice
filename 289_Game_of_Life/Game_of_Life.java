// https://leetcode.com/problems/game-of-life/

public class Solution {
    public void gameOfLife(int[][] board) {
        if(board == null || board.length == 0){
            return;
        }
        //use 2 to represent a living life will die in the next gen
        //use 3 to represent a dead life will live in the next gen
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                //count neighbors
                int count = 0;
                if(i > 0){
                    if(j > 0 && (board[i - 1][j - 1] == 1 || board[i - 1][j - 1] == 2)) count++;
                    if(board[i - 1][j] == 1 || board[i - 1][j] == 2)     count++;
                    if(j + 1 < board[0].length && (board[i - 1][j + 1] == 1 || board[i - 1][j + 1] == 2)) count++;
                }
                if(i + 1 < board.length){
                    if(j > 0 && (board[i + 1][j - 1] == 1 || board[i + 1][j - 1] == 1)) count++;
                    if(board[i + 1][j] == 1 || board[i + 1][j] == 2)     count++;
                    if(j + 1 < board[0].length && (board[i + 1][j + 1] == 1 || board[i + 1][j + 1] == 2)) count++;
                }
                if(j > 0 && (board[i][j - 1] == 1 || board[i][j - 1] == 2)) count++;
                if(j + 1 < board[0].length && (board[i][j + 1] == 1 || board[i][j + 1] == 2)) count++;
                //predict next gen
                if(board[i][j] == 1){
                    if(count < 2 || count > 3) board[i][j] = 2;
                }
                else{
                    if(count == 3) board[i][j] = 3;
                }
            }
        }
        //modify the array to show result
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                board[i][j] %= 2;
            }
        }
    }
}