package leet_code;

import java.util.Arrays;

public class ReverseArrayString {
	public static void main(String[] args) {
		String str = "ritesh";
		System.out.println(reverseStr(str, 2));
	}

	public static char[] reverseString(char[] str) {
		int s = 0, l = str.length - 1;
		while (s < l) {
			char c = str[s];
			str[s] = str[l];
			str[l] = c;
			s++;
			l--;
		}
		return str;
	}

	public static String reverseStr(String s, int k) {
		char[] arr = s.toCharArray();
		int i;
		StringBuilder res = new StringBuilder();
		for (i = 0; i < arr.length && i + k < arr.length; i += 2 * k) {
			res.append(Arrays.toString(reverseString(s.substring(i, i + k).toCharArray())));
		}
		return res.toString();
	}
}
