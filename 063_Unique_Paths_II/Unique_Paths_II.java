// https://leetcode.com/problems/unique-paths-ii/

public class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] path = new int[m][n];
        
        for(int i = 0; i < n; i++){
            if(grid[0][i] != 1){
                path[0][i] = 1;
            }
            else{
                break;
            }
        }
        
        for(int i = 0; i < m; i++){
            if(grid[i][0] != 1){
                path[i][0] = 1;
            }
            else{
                break;
            }
        }
        
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(grid[i][j] != 1){
                    path[i][j] = path[i - 1][j] + path[i][j - 1];
                }
            }
        }
        
        return path[m - 1][n - 1];
    }


    // 1D dp solution
    public int uniquePathsWithObstacles_1(int[][] obstacleGrid) {
        int rows = obstacleGrid.length;
        int cols = (rows == 0) ? 0 : obstacleGrid[0].length;
        int[] dp = new int[cols];
        dp[0] = 1;
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < cols; j++){
                if(obstacleGrid[i][j] == 1){
                    dp[j] = 0;
                }
                else if(j > 0){
                    dp[j] += dp[j - 1];
                }
            }
        }
        return dp[cols - 1];
    }
}