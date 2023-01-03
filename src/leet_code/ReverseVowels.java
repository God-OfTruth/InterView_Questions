package leet_code;

import java.util.ArrayList;
import java.util.List;

public class ReverseVowels {
	public static void main(String[] args) {
		System.out.println(reverseVowels("Ritesh"));
	}

	public static String reverseVowels(String s) {
		char[] arr = s.toCharArray();
		List<Integer> pos = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) if (checkVowel(arr[i])) pos.add(i);
		int st = 0, la = pos.size() - 1;
		while (st <= la) {
			char c = arr[pos.get(st)];
			arr[pos.get(st)] = arr[pos.get(la)];
			arr[pos.get(la)] = c;
			st++;
			la--;
		}
		StringBuilder res = new StringBuilder();
		for (char c : arr) res.append(c);
		return res.toString();
	}

	public static boolean checkVowel(char c) {
		return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
	}
}
