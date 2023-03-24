package gfg;

public class RemoveAndReverse {
	public static void main(String[] args) {
		String s = "dddd";
		System.out.println(removeReverse(s));
	}

	static String removeReverse(String S) {
		int[] fre = new int[26];
		for (int i = 0; i < S.length(); i++) fre[S.charAt(i) - 'a']++;
		int i = 0, j = S.length() - 1, time = 0;
		byte[] isRemoved = new byte[S.length()];
		while (i <= j) if (time % 2 == 0) {
			int c = S.charAt(i) - 'a';
			if (fre[c] > 1) {
				time++;
				isRemoved[i] = 1;
				fre[c]--;
			}
			i++;
		} else {
			int c = S.charAt(j) - 'a';
			if (fre[c] > 1) {
				time++;
				isRemoved[j] = 1;
				fre[c]--;
			}
			j--;
		}
		StringBuilder sb = new StringBuilder();
		for (i = 0; i < S.length(); i++) if (isRemoved[i] == 0) sb.append(S.charAt(i));
		if (time % 2 == 1) sb.reverse();
		return sb.toString();
	}
}
