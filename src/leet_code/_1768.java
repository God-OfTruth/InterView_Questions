package leet_code;

public class _1768 {

	/**
	 * You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. If a string is longer than the other, append the additional letters onto the end of the merged string.
	 * Return the merged string.
	 * Example 1:
	 * Input: word1 = "abc", word2 = "pqr"
	 * Output: "apbqcr"
	 * Explanation: The merged string will be merged as so:
	 * word1:  a   b   c
	 * word2:    p   q   r
	 * merged: a p b q c r
	 *
	 * @param word1 Word1
	 * @param word2 Word2
	 * @return Merged String
	 */
	public static String mergeAlternately(String word1, String word2) {
		final int n = Math.min(word1.length(), word2.length());
		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < n; i++) {
			sb.append(word1.charAt(i));
			sb.append(word2.charAt(i));
		}
		return sb.append(word1.substring(n)).append(word2.substring(n)).toString();
	}

	public static void main(String[] args) {
		System.out.println(mergeAlternately("abc", "pqr"));
	}
}
