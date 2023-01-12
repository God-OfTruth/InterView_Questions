package gfg;

import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {
	public static void main(String[] args) {
		String[] dict = {"baa", "abcd", "abca", "cab", "cad"};
		int k = 4;
		System.out.println(findOrder(dict, dict.length, k));
	}

	public static String findOrder(String[] dict, int n, int K) {
		List<Character> list = new LinkedList<>();
		for (int i = 0; i < n - 1; i++) {
			String word1 = dict[i];
			String word2 = dict[i + 1];
			int x=0;
			while (true){
				x++;
				if (x >= word1.length() || x >= word2.length()) break;
				if (word1.charAt(x) == word2.charAt(x)) continue;
				list.add(word1.charAt(x));

			}
		}
		return list.toString();
	}
}
