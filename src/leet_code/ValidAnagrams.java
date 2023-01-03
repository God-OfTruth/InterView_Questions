package leet_code;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ValidAnagrams {
	public static void main(String[] args) {
		String s = "car";
		String t = "rae";
		System.out.println(isAnagram(s, t));
	}
	public static boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;
		Map<Character, Integer> map = new HashMap<>();
		Map<Character, Integer> map1 = new HashMap<>();
		for(char c: s.toCharArray()){
			if(map.containsKey(c)) map.put(c, map.get(c)+1);
			else map.put(c, 1);
		}
		for(char c: t.toCharArray()){
			if(map1.containsKey(c)) map1.put(c, map1.get(c)+1);
			else map1.put(c, 1);
		}
		for(char c: map.keySet()) if(!Objects.equals(map.get(c), map1.get(c))) return false;
		return true;
	}
}
