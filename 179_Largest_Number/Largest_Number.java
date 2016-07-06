// https://leetcode.com/problems/largest-number/

public class Solution {
    public String largestNumber(int[] nums) {
        if(nums == null || nums.length == 0){
            return "";
        }
        String[] s = new String[nums.length];
        for(int i = 0; i < nums.length; i++){
            s[i] = nums[i] + "";
        }
        Comparator<String> comp = new Comparator<String>(){
            @Override
            public int compare(String s1, String s2){
                return (s1 + s2).compareTo(s2 + s1);
            }
        };
        Arrays.sort(s, comp);
        if(s[s.length - 1].charAt(0) == '0'){
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < s.length; i++){
            sb.insert(0, s[i]);
        }
        return sb.toString();
    }
}