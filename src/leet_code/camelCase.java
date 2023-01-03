package leet_code;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
public class camelCase {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String statement = sc.nextLine();
		String output = convert(statement);
		sc.close();
	}
	public static String convert(String str) {
		List<String> s = new ArrayList<>(); 
		int start=0;
		for(int i=0; i<str.length(); i++) {
			char ch=str.charAt(i);
			if(Character.isUpperCase(ch)) {
				s.add((str).substring(start, i));
				start=i;
			}
		}
		s.add(str.substring(start));
		StringBuilder o= new StringBuilder();
		for(String i:s) o.append(reverse(i)).append(" ");
		return o.toString();
	}
	public static String reverse(String s) {
		StringBuilder rev= new StringBuilder();
		s=s.toLowerCase();
		for(int i=0; i<s.length(); i++) rev.insert(0, s.charAt(i));
		return rev.toString();
	}

}
