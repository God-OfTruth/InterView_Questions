package leet_code;

import java.util.ArrayList;
import java.util.List;

public class _131 {
	static List<List<String>> res = new ArrayList<>();

	public static void main(String[] args) {
		res.clear();
		System.out.println(partition("aab"));
	}

	public static List<List<String>> partition(String s) {
		recur(s, 0, new ArrayList<>());
		return res;
	}

	private static void recur(String s, int index, ArrayList<String> subList) {
		if (s.length() == index) {
			res.add(new ArrayList<>(subList));
			return;
		}
		for (int i = index; i < s.length(); i++) {
			if (isPalindrome(s, index, i)) {
				subList.add(s.substring(index, i + 1));
				recur(s, i + 1, subList);
				subList.remove(subList.size() - 1);
			}
		}
	}

	private static boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) != s.charAt(end)) return false;
			start++;
			end--;
		}
		return true;
	}
}
