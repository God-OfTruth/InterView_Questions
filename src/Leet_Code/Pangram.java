package Leet_Code;

import java.util.HashSet;
import java.util.Set;

public class Pangram {
	public static void main(String[] args) {
		System.out.println(checkIfPangram("thequickbrownfoxjumpsoverthelazydog"));
	}

	public static boolean checkIfPangram(String sentence) {
		sentence = sentence.toLowerCase();
		Set<Character> set = new HashSet<>();
		for (char c : sentence.toCharArray())
			if (!set.contains(c)) {
				set.add(c);
				if (set.size() == 26) return true;
			}
		return false;
	}
}
