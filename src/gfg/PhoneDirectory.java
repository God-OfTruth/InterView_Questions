package gfg;

import java.util.ArrayList;
import java.util.Collections;

public class PhoneDirectory {
	public static void main(String[] args) {
		String[] arr = {"abznehvggnuadsko", "abdnhtuydwvvh", "abqljekyiuvqajk", "abocnecsrlmnkp", "abhmtxfejjrhtldl" ,"abovqcafic", "abzqmnabyjprhuwqfnz" ,"abaclpshgwjnenlgdxtfa" ,"abpqjymhouwpswuelmntjy", "abpluvrsow"};
		String str = "aboikd";
		for (ArrayList<String> s: displayContacts(arr.length, arr, str)){
			System.out.println(s);
		}

	}
	static ArrayList<ArrayList<String>> displayContacts(int n, String[] contacts, String s) {
		ArrayList<ArrayList<String>> lists = new ArrayList<>();
		System.out.println(n+", "+s.length());
		if (contacts.length == 0) return lists;
		for (int i=1; i<=s.length(); i++){
			lists.add(getContacts(contacts, s.substring(0, i)));
		}
		return lists;
	}

	private static ArrayList<String> getContacts(String[] contacts, String str) {
		ArrayList<String> res = new ArrayList<>();
		for (String s: contacts) {
			if (s.startsWith(str)) res.add(s);
			else {
				if (res.isEmpty())
					res.add("0");
				return res;
			}
		}
		Collections.sort(res);
		return res;
	}
}
