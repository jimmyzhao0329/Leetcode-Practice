// https://leetcode.com/problems/search-a-2d-matrix-ii/

public class Solution {
    public boolean searchMatrix(int[][] m, int tar) {
        if(m == null || m.length == 0){
            return false;
        }
        int col = m[0].length - 1;
        int row = 0;
        while(col >= 0 && row < m.length){
            if(m[row][col] == tar){
                return true;
            }
            else if(m[row][col] > tar){
                col--;
            }
            else{
                row++;
            }
        }
        return false;
    }
}

//Time complexity is O(m + n)