// https://leetcode.com/problems/range-sum-query-2d-immutable/

public class NumMatrix {

    private int[][] sum;
    
    public NumMatrix(int[][] m) {
        if(m == null || m.length == 0 || m[0].length == 0){
            return;   
        }
        sum = new int[m.length + 1][m[0].length + 1];
        for(int i = 1; i <= m.length; i++){
            for(int j = 1; j <= m[0].length; j++){
                sum[i][j] = m[i - 1][j - 1] + sum[i - 1][j] + sum[i][j - 1] - sum[i - 1][j - 1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return sum[row2 + 1][col2 + 1] - sum[row1][col2 + 1] - sum[row2 + 1][col1] + sum[row1][col1];
    }
}


// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);