package gfg;

import java.util.HashMap;
import java.util.Map;

public class BalloonEverywhere {
	public static void main(String[] args) {
		String s = "nlaebolko";
		System.out.println(maxInstance(s));
	}

	public static int maxInstance(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if (ch == 'b' || ch == 'a' || ch == 'l' || ch == 'o' || ch == 'n') {
				if (map.containsKey(ch)) map.put(ch, map.get(ch) + 1);
				else map.put(ch, 1);
			}
		}
		if (map.get('l') != null) map.put('l', map.get('l') / 2);
		if (map.get('o') != null) map.put('o', map.get('o') / 2);
		int min = Integer.MAX_VALUE;
		for (int i : map.values())
			min = Math.min(i, min);
		return min;
	}
}
