// https://leetcode.com/problems/triangle/

public class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int h = triangle.size();
        int[] res = new int[h + 1];
        for(int i = h - 1; i >= 0; i--){
            for(int j = 0; j < triangle.get(i).size(); j++){
                int min = Math.min(res[j], res[j + 1]);
                res[j] = triangle.get(i).get(j) + min;
            }
        }
        return res[0];
    }
}