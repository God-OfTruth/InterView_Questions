package leet_code;

import java.util.*;

public class GroupAnagrams {
	public static void main(String[] args) {
		String[] arr = {"eat","tea","tan","ate","nat","bat"};
		System.out.println(groupAnagrams(arr));
	}
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) return null;
		Map<String, List<String>> map = new HashMap<>();
		for (String word : strs) {
			String currMap = countCharacter(word);
			map.computeIfAbsent(currMap, x -> new ArrayList<>()).add(word);
		}
		return new ArrayList<>(map.values());
	}
	public static String countCharacter(String str) {
		int[] map = new int[26];
		for (char c : str.toCharArray()) map[c - 'a']++;
		return Arrays.toString(map);
	}
}
