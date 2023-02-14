package gfg;

import java.util.HashMap;
import java.util.Map;

public class ScrambledString {
	static Map<String, Boolean> map = new HashMap<>();

	public static void main(String[] args) {
		String s1 = "ocerd";
		String s2 = "coder";
		System.out.println(isScramble(s1, s2));
	}

	static boolean isScramble(String S1, String S2) {
		if (S1.length() != S2.length()) return false;
		if (S1.equals(S2)) return true;
		int n = S1.length();
		boolean[][][] dp = new boolean[n][n][n + 1];
		for (int i = 0; i < n; i++)
			for (int j = 0; j < n; j++)
				dp[i][j][1] = S1.charAt(i) == S2.charAt(j);
		for (int l = 2; l <= n; l++)
			for (int i = 0; i <= n - l; i++)
				for (int j = 0; j <= n - l; j++) {
					dp[i][j][l] = false;
					for (int k = 1; k < l; k++) {
						if (dp[i][j][k] && dp[i + k][j + k][l - k]) {
							dp[i][j][l] = true;
							break;
						}
						if (dp[i][j + l - k][k] && dp[i + k][j][l - k]) {
							dp[i][j][l] = true;
							break;
						}
					}
				}
		return dp[0][0][n];
	}

	static boolean fun(String s1, String s2) {
		int n = s1.length();
		if (s1.equals(s2)) {
			map.put(s1 + s2, true);
			return true;
		}
		if (map.containsKey(s1 + s2)) return map.get(s1 + s2);
		for (int i = 1; i < n; i++) {
			String a = s1.substring(0, i);
			String b = s2.substring(0, i);
			String c = s1.substring(i, n);
			String d = s2.substring(i, n);
			if (fun(a, b) && fun(c, d)) {
				map.put(s1 + s2, true);
				return true;
			}
			String e = s1.substring(0, i);
			String f = s2.substring(n - i, n);
			String g = s1.substring(i, n);
			String h = s2.substring(0, n - 1);
			if (fun(e, f) && fun(g, h)) {
				map.put(s1 + s2, true);
				return true;
			}
		}
		map.put(s1 + s2, false);
		return false;
	}
}
