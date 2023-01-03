package leet_code;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class LongestPalindrome {
	public static void main(String[] args) {
		String s = "a";
		System.out.println(longestPalindrome(s));
	}

	public static int longestPalindrome(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (char c: s.toCharArray()) map.put(c, map.getOrDefault(c, 0) + 1);
		int ans = 0;
		Iterator<Entry<Character, Integer>> it = map.entrySet().iterator();
		while (it.hasNext()) {
			Entry<Character, Integer> entry = it.next();
			int count = entry.getValue();
			if (count % 2 == 0) {
				ans += count;
				it.remove();
			} else {
				ans += count - 1;
				map.put(entry.getKey(), 1);
			}
		}
		return map.isEmpty() ? ans : ans + 1;
	}
}
