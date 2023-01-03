package leet_code;

import java.util.Map;
import java.util.TreeMap;

public class SortByFrequency {
	public static void main(String[] args) {
		String s = "Aabb";
		System.out.println(frequencySort(s));
	}

	public static String frequencySort(String s) {
		Map<Character, Integer> map = new TreeMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		System.out.println(map);
		return "";
	}
}
