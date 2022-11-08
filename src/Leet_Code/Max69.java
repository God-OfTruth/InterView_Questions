package Leet_Code;

import java.util.regex.Pattern;

public class Max69 {
	public static void main(String[] args) {
		System.out.println(maximum69Number(9696));
	}
	/*
	*
	* */
	public static int maximum69Number (int num) {
//		return Integer.parseInt(String.valueOf(num).replaceFirst("6", "9"));
		return Integer.parseInt(Pattern.compile("6").matcher(String.valueOf(num)).replaceFirst("9"));
	}
}
