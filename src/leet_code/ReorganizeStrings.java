package leet_code;

public class ReorganizeStrings {
	public static void main(String[] args) {
		String s = "baaba";
		System.out.println(reorganizeString(s));
	}

	public static String reorganizeString(String s) {
		final int n = s.length();
		int[] count = new int[128];
		char maxChar = 'a' - 1;
		for (final char c : s.toCharArray())
			++count[c];
		for (char c = 'a'; c <= 'z'; ++c)
			if (count[c] > count[maxChar]) maxChar = c;
		if (count[maxChar] > (n + 1) / 2) return "";
		char[] ans = new char[n];
		while (count[maxChar]-- > 0) fillIn(ans, maxChar);
		for (char c = 'a'; c <= 'z'; ++c)
			while (count[c] > 0) {
				--count[c];
				fillIn(ans, c);
			}
		return new String(ans);
	}

	static int i = 0;

	private static void fillIn(char[] ans, char c) {
		ans[i] = c;
		i += 2;
		if (i >= ans.length) i = 1;
	}
}
