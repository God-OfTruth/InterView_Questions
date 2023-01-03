package leet_code;

public class InterleavingString {
	public static void main(String[] args) {
		String s1 = "aabcc";
		String s2 = "dbbca";
		String s3 = "aadbbcbcac";
		System.out.println(isInterleaved(s1, s2, s3));
	}

	public static boolean isInterleave(String s1, String s2, String s3) {
		if (s3.equals("")) return true;
		if ((s1 + s2).length() != s3.length()) return false;
		int j = 0;
		int k = 0;
		StringBuilder builder = new StringBuilder();
		for (int i = 0; i < s3.length() && k < s2.length(); ) {
			if (j < s1.length() && s3.charAt(i) == s1.charAt(j)) {
				builder.append(s3.charAt(i));
				i++;
				j++;
			} else if (s3.charAt(i) == s2.charAt(k)) {
				builder.append(s3.charAt(i));
				i++;
				k++;
			} else {
				j++;
				k++;
			}
			if (i >= s3.length()) {
				return true;
			}
		}
		System.out.println(builder);
		return false;
	}

	public static boolean isInterleaved(String s1, String s2, String s3) {{
			if (s3.length() != s1.length() + s2.length()) return false;
			boolean[][] dp = new boolean[s1.length() + 1][s2.length() + 1];
			for (int i = 0; i <= s1.length(); i++) {
				for (int j = 0; j <= s2.length(); j++) {
					if (i == 0 && j == 0) {
						dp[i][j] = true;
					} else if (i == 0) {
						dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1);
					} else if (j == 0) {
						dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1);
					} else {
						dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
					}
				}
			}
			return dp[s1.length()][s2.length()];
		}
	}
}
