package personal;

import java.util.Arrays;
import java.util.HashMap;

public class Scramble {
	public static void main(String[] args) {
		String s1 = "h311ko";
		String s2 = "hello";
		System.out.println(stringScramble(s1, s2));
	}

	static HashMap<String, Boolean> mp = new HashMap<>();

	static boolean stringScramble(String s1, String s2) {
		if (s1.length() != s2.length()) {
			return false;
		}
		int n = s1.length();
		if (n == 0) {
			return true;
		}
		if (s1.equals(s2)) {
			return true;
		}
		String copy_s1 = s1, copy_s2 = s2;
		char[] t1 = copy_s1.toCharArray();
		char[] t2 = copy_s2.toCharArray();
		Arrays.sort(t1);
		Arrays.sort(t2);
		copy_s1 = new String(t1);
		copy_s2 = new String(t2);

		if (!copy_s1.equals(copy_s2)) {
			return false;
		}

		String key = (s1 + " " + s2);
		if (mp.containsKey(key)) {
			return mp.get(key);
		}

		boolean flag = false;
		for (int i = 1; i < n; i++) {
			if (stringScramble(s1.substring(0, i), s2.substring(0, i)) && stringScramble(s1.substring(i, n), s2.substring(i, n))) {
				flag = true;
				mp.put(key, flag);
				return true;
			}
			if (stringScramble(s1.substring(0, i), s2.substring(n - i, n))
					&& stringScramble(s1.substring(i, n),
					s2.substring(0, n - i))) {
				flag = true;
				mp.put(key, flag);
				return true;
			}
		}
		mp.put(key, flag);
		return false;
	}
}
