// https://leetcode.com/problems/word-search/

public class Solution {
    private boolean find(char[][] board, String word, int start, int i, int j){
        if(start == word.length()){
            return true;
        }
        if(i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(start)){
            return false;
        }
        char c = board[i][j];
        board[i][j] = '*';
        boolean res = find(board, word, start + 1, i - 1, j) || find(board, word, start + 1, i + 1, j)
                    ||find(board, word, start + 1, i, j - 1) || find(board, word, start + 1, i, j + 1);
        board[i][j] = c;
        return res;
        
    }
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(find(board, word, 0, i, j)){
                        return true;
                    }   
                }
            }
        }
        return false;
    }
}