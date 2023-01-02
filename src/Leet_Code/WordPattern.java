package Leet_Code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class WordPattern {
	public static void main(String[] args) {
		String pattern = "abba";
		String s = "dog cat cat dog";
		System.out.println(wordPattern(pattern, s));
	}

	public static boolean wordPattern(String pattern, String s) {
		String[] words = s.split(" ");
		if (words.length != pattern.length()) return false;
		Map<Character, Integer> charToIndex = new HashMap<>();
		Map<String, Integer> stringToIndex = new HashMap<>();
		for (int i = 0; i < pattern.length(); ++i)
			if (!Objects.equals(charToIndex.put(pattern.charAt(i), i), stringToIndex.put(words[i], i))) return false;
		return true;
	}
}
