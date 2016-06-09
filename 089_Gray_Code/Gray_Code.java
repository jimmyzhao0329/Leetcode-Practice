// https://leetcode.com/problems/gray-code/

public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<Integer>();
        if(n < 0){
            return res;
        }
        res.add(0);
        for(int i = 0; i < n; i++){
            int curSize = res.size();
            while(curSize > 0){
                curSize--;
                int temp = res.get(curSize);
                temp += (1 << i);
                res.add(temp);
            }
        }
        return res;
    }
}