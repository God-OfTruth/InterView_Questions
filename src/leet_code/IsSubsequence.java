package leet_code;

public class IsSubsequence {
	public static void main(String[] args) {
		String s = "abc";
		String t = "ahbgdc";
		System.out.println(isSubsequence(s, t));
	}

	static boolean isSubsequence(String s1, String s2) {
		int n = s1.length();
		int m = s2.length();
		int i = 0;
		int j = 0;
		while (i < n && j < m) {
			if (s1.charAt(i) == s2.charAt(j)) i++;
			j++;
		}
		return i == n;
	}
}
