// public class Solution {
    public int numIslands(char[][] grid) {
        int count = 0;
        int row = grid.length;
        if(row == 0){
            return 0;
        }
        int col = grid[0].length;
        for(int i = 0; i < row; i++){
            for(int j = 0; j < col; j++){
                if(grid[i][j] == '1'){
                    count++;
                    helper(grid, i, j);
                }
            }
        }
        return count;
    }
    
    private void helper(char[][] grid, int i, int j){
        grid[i][j] = '*';
        if(i > 0 && grid[i - 1][j] == '1'){
            helper(grid, i - 1, j);
        }
        if(i < grid.length - 1 && grid[i + 1][j] == '1'){
            helper(grid, i + 1, j);
        }
        if(j > 0 && grid[i][j - 1] == '1'){
            helper(grid, i, j - 1);
        }
        if(j < grid[0].length - 1 && grid[i][j + 1] == '1'){
            helper(grid, i, j + 1);
        }
    }
}

