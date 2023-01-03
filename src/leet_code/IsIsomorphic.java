package leet_code;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {
	public static void main(String[] args) {
		String s = "foo";
		String t = "bar";
		System.out.println(isIsomorphic(s, t));
	}

	public static boolean isIsomorphic(String s, String t) {
		Map<Character, Character> charCount = new HashMap<>();
		char c;
		for (int i = 0; i < s.length(); i++)
			if (charCount.containsKey(s.charAt(i))) {
				c = charCount.get(s.charAt(i));
				if (c != t.charAt(i))
					return false;
			} else if (!charCount.containsValue(t.charAt(i))) {
				charCount.put(s.charAt(i), t.charAt(i));
			} else return false;
		return true;
	}
}
