// https://leetcode.com/problems/spiral-matrix/

public class Solution {
    public List<Integer> spiralOrder(int[][] num) {
        List<Integer> res = new ArrayList<Integer>();
        int m = num.length;
        if(m == 0){
            return res;
        }
        int n = num[0].length;
        if(n == 0){
            return res;
        }
        
        int rowUp = 0, rowDown = m - 1;
        int colLeft = 0, colRight = n - 1;
        while(true){
            for(int j = colLeft; j <= colRight; j++){
                res.add(num[rowUp][j]);
            }
            rowUp++;
            if(rowUp > rowDown){
                break;
            }
            
            for(int i = rowUp; i <= rowDown; i++){
                res.add(num[i][colRight]);
            }
            colRight--;
            if(colRight < colLeft){
                break;
            }
            
            for(int j = colRight; j >= colLeft; j--){
                res.add(num[rowDown][j]);
            }
            rowDown--;
            if(rowUp > rowDown){
                break;
            }

            for(int i = rowDown; i >= rowUp; i--){
                res.add(num[i][colLeft]);
            }
            colLeft++;
            if(colRight < colLeft){
                break;
            }
        }
        
        return res;
    }
}