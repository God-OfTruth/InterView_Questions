package gfg;

public class FormAPalindrome {
	public static void main(String[] args) {
		String s = "abcab";
		System.out.println(getRes(s));
	}

	public static int getRes(String str) {
		if (str.length() == 1) return 0;
		int[][] dp = new int[str.length()][str.length()];
		for (int g = 0; g < str.length(); g++)
			for (int i = 0, j = g; j < str.length(); j++, i++)
				if (g == 0) dp[i][j] = 0;
				else {
					final boolean b1 = str.charAt(i) == str.charAt(j);
					if (g == 1) dp[i][j] = b1 ? 0 : 1;
					else if (b1) dp[i][j] = dp[i + 1][j - 1];
					else dp[i][j] = Math.min(dp[i + 1][j], dp[i][j - 1]) + 1;
				}
		return dp[0][str.length() - 1];
	}
}
