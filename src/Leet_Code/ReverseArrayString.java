package Leet_Code;

import java.util.Arrays;

public class ReverseArrayString {
	public static void main(String[] args) {
		char[] arr = {'h', 'e', 'l', 'l', 'o'};
//		System.out.println(arr);
//		reverseString(arr);
//		System.out.println(arr);
		System.out.println(reverseStr("abcdefg", 2));
	}

	public static char[] reverseString(char[] str) {
		System.out.println(str);
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
		int i = 0;
		StringBuilder res = new StringBuilder();
		for (i = 0; i < arr.length && i+k < arr.length; i += 2 * k) {
			res.append(Arrays.toString(reverseString(s.substring(i, i + k).toCharArray())));
		}
		System.out.println(i- k*2 +k);
		return res.toString();
	}

	private static void reverse(char[] arr, int i, int k) {
//		System.out.println(arr);
		reverseString(Arrays.toString(arr).substring(i, i + k).toCharArray());
	}
}
