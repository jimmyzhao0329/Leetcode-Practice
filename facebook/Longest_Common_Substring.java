// http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-substring/

public class Longest_Common_Substring {
	public static boolean LCS(String a, String b){
		if(a == null || a.length() == 0 ||
			b == null || b.length() == 0){
			return false;
		}

		int[][] dp = new int[a.length() + 1][b.length() + 1];

		for(int i = 1; i < a.length(); i++){
			for(int j = 1; j < b.length(); j++){
				if(a.charAt(i - 1) == b.charAt(j - 1)){
					dp[i][j] = 1 + dp[i - 1][j - 1];
				}
			}
		}

		int res = 0;
		for(int i = 0; i < a.length(); i++){
			for(int j = 0; j < b.length(); j++){
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}
}