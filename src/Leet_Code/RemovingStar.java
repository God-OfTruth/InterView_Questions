package Leet_Code;

import java.util.Arrays;
import java.util.Stack;

public class RemovingStar {
	public static void main(String[] args) {
		String s = "erase******";
		System.out.println(removeStars(s));
	}

	public static String removeStars(String s) {
		StringBuilder builder = new StringBuilder();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (j > 0 && s.charAt(i) == '*') {
				builder.deleteCharAt(j - 1);
				j--;
			} else {
				j++;
				builder.append(s.charAt(i));
			}
		}
		return builder.toString();
	}
}

/*
*  j = 4
*  builder = l, e, e, t
* */