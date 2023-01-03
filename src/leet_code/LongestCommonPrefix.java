package leet_code;

import java.util.Arrays;

public class LongestCommonPrefix {
	public static void main(String[] args) {
		String[] strings = {"flower", "flow", "flight"};
		System.out.println(longestCommonPrefix(strings));
	}

	public static String longestCommonPrefix(String[] strs) {
		int size = strs.length;
		if (size == 0)
			return "";
		if (size == 1)
			return strs[0];
		Arrays.sort(strs);
		int end = Math.min(strs[0].length(), strs[size - 1].length());
		int i = 0;
		while (i < end && strs[0].charAt(i) == strs[size - 1].charAt(i))
			i++;
		return strs[0].substring(0, i);
	}
}
