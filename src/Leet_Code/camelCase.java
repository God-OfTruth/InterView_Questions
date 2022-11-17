package Leet_Code;

import java.util.Scanner;
import java.util.ArrayList;
public class camelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String statement = sc.nextLine();
		String output = convert(statement);
		System.out.println(output);
		sc.close();
	}
	public static String convert(String str) {
		ArrayList<String> s = new ArrayList<>(); 
		int start=0;
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if(Character.isUpperCase(ch)) {
				s.add((str).substring(start, i));
				start=i;
			}
		}
		s.add(str.substring(start));
		String o="";
		for(String i:s) {
			o=o+reverse(i)+" ";
		}
		return o;
	}
	public static String reverse(String s) {
		String rev="";
		s=s.toLowerCase();
		for(int i=0; i<s.length(); i++)
			rev=s.charAt(i)+rev;
		return rev;
	}

}
