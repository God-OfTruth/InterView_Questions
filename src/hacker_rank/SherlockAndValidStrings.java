package hacker_rank;

import java.util.*;

public class SherlockAndValidStrings {
	public static void main(String[] args) {
		String s = "abcdefghhgfedecba";
		System.out.println(isValid(s));
	}

	public static String isValid(String s) {
		Map<Character, Integer> map = new TreeMap<>();
		for (char c : s.toCharArray()) {
			if (map.containsKey(c)) {
				map.put(c, map.get(c) + 1);
			} else {
				map.put(c, 1);
			}
		}
		boolean flag = false;
		int first = map.get(s.charAt(0)), last = map.get(s.charAt(1));
		List<Integer> integers = new ArrayList<>(map.values().stream().toList());
		integers.sort(null);
		for (int i : integers) {
			System.out.print(" " + i);
		}
		return "";
	}
}
