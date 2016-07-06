// https://leetcode.com/problems/repeated-dna-sequences/

public class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        Set<String> seen = new HashSet<String>();
        Set<String> res = new HashSet<String>();
        for(int i = 0; i + 9 < s.length(); i++){
            String temp = s.substring(i, i + 10);
            if(!seen.add(temp)){
                res.add(temp);
            }
        }
        return new ArrayList(res);
        
    }
}