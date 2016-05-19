public class Solution {
    public String convert(String s, int numRows) {
        if(numRows <= 1){
            return s;
        }
        
        String[] store = new String[numRows];
        Arrays.fill(store, "");
        String res = "";
        int dirc = 1;
        int row = 0;
        
        for(int i = 0; i < s.length(); i++){
            store[row] += s.charAt(i);
            row = row + dirc;
            if(row == numRows - 1){
                dirc = -1;
            }
            else if(row == 0){
                dirc = 1;
            }
            else{
                continue;
            }
        }
        
        for(int i = 0; i < numRows; i++){
            res += store[i];
        }
        
        return res;
    }
}