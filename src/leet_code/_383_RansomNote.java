package leet_code;

import java.util.HashMap;
import java.util.Map;

public class _383_RansomNote {
	public static void main(String[] args) {

	}

	public boolean canConstruct(String ransomNote, String magazine) {
		Map<Character, Integer> characterMap = new HashMap<>();
		for (char c : magazine.toCharArray()) {
			characterMap.put(c, characterMap.getOrDefault(c, 0) + 1);
		}
		for (char c : ransomNote.toCharArray()) {
			if (characterMap.containsKey(c)) {
				int count = characterMap.get(c);
				count--;
				if (count != 0) {
					characterMap.put(c, count);
				} else {
					characterMap.remove(c);
				}
			} else {
				return false;
			}
		}
		return true;
	}
}
