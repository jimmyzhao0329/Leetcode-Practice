// https://leetcode.com/problems/pascals-triangle/

public class Solution {
    public List<List<Integer>> generate(int n) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n <= 0){
            return res;
        }
        List<Integer> cur = new ArrayList<Integer>();
        cur.add(1);
        res.add(cur);
        for(int i = 1; i < n; i++){
            List<Integer> temp = new ArrayList<Integer>();
            temp.add(1);
            List<Integer> pre = res.get(i - 1);
            for(int j = 1; j < i; j++){
                temp.add(pre.get(j - 1) + pre.get(j));
            }
            temp.add(1);
            res.add(temp);
        }
        return res;
    }
}