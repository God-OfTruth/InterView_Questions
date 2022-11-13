package GFG;

public class LongestCommonSubstring {
	public static void main(String[] args) {
		String S1 = "ADAC", S2 = "ADADAC";
		int n = 6, m = 6;
		System.out.println(longestCommonSubStr(S1, S2, S1.length(), S2.length()));
	}

	/*
	* Need to Work on it
	* */
	static int longestCommonSubStr(String s1, String s2, int n, int m){
		// code here
		if(n == 0 || m == 0) return 0;
		int count =0,max = 0;
		boolean[][] dp = new boolean[n][m];
		dp[0][0] = true;
		for(int i = 0 ; i < n ; i++ ){
			for(int j = 0 ; j < m ; j++){
				if(s1.charAt(i) == s2.charAt(j)) dp[i][j] = true;
				if(dp[i][j] &&  (i > 0 && j > 0 && dp[i - 1][j - 1]))count++;
				else if(dp[i][j]) count = 1;
				max = Math.max(max,count);
			}
		}
		return max;
	}
}
