// https://leetcode.com/problems/anagrams/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        
        Arrays.sort(strs);
        for(String s : strs){
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String key = new String(arr);
            
            if(map.containsKey(key)){
                map.get(key).add(s);
            } 
            else{
                ArrayList<String> l = new ArrayList<String>();
                l.add(s);
                map.put(key, l);
            }
        }
        
        res.addAll(map.values());
        return res;
    }
}