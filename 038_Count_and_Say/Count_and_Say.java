//https://leetcode.com/problems/count-and-say/

public class Solution {
	public String countAndSay(int n) {
	    String res = "1";
	    for(int i = 1; i < n; i++){
	        res = count(res);
	    }
	    return res;
	}

	private String count(String s){
	    StringBuilder res = new StringBuilder();
	    int count = 1;
	    for(int i = 1; i < s.length(); i++){
	        if(s.charAt(i - 1) != s.charAt(i)){
	            res.append(count);
	            res.append(s.charAt(i - 1));
	            count = 1;
	        }
	        else{
	            count++;
	        }
	    }
	    res.append(count);
	    res.append(s.charAt(s.length() - 1));
	    return res.toString();
	}
}