package personal;

import java.util.HashSet;

public class UniqueSubstringCounter {
	public static int findSubstrings(String s) {
		int n = s.length();
		int start = 0, end = 0;
		HashSet<Character> seen = new HashSet<>();
		int count = 0;

		while (end < n) {
			char currentEndChar = s.charAt(end);

			// If the character is not in the set, add it and update the count
			if (!seen.contains(currentEndChar)) {
				seen.add(currentEndChar);
				// Number of new substrings that end at position `end`
				count += (end - start + 1);
				end++;
			} else {
				// Remove the start character from the set and move the start pointer
				seen.remove(s.charAt(start));
				start++;
			}
		}

		return count;
	}

	public static void main(String[] args) {
		String s = "abac";
		System.out.println(findSubstrings(s));  // Output: 8
	}
}
