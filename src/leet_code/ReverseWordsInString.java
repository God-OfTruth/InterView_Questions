package leet_code;

import java.util.Objects;

public class ReverseWordsInString {
	public static void main(String[] args) {
		String s = "a good   example";
		System.out.println(reverseWords(s));
	}

	public static String reverseWords(String s) {
		StringBuilder res = new StringBuilder();
		for (String value : s.trim().split(" "))
			if (!Objects.equals(value, ""))
				res.insert(0, value + " ");
		return res.toString().trim();
	}
}
