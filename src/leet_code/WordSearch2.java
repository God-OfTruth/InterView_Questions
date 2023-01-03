package leet_code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class WordSearch2 {
	public static void main(String[] args) {
		char[][] chars = {{'o', 'o', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
		String[] words = {"eat"};
		System.out.println(exist(chars, "eat"));
//		findWords(chars, words).forEach(System.out::println);
	}

	public static List<String> findWords(char[][] board, String[] words) {
		if (words.length == 0) return new ArrayList<>();
		Trie trie = new Trie();
		for (String w : words) {
			trie.insert(w);
		}

		HashSet<String> result_s = new HashSet<>();
		for (int i = 0; i < board.length; ++i) {
			for (int j = 0; j < board[0].length; ++j) {
				dfs(board, i, j, trie, result_s, "");
			}
		}
		return new ArrayList<>(result_s);
	}

	public static boolean exist(char[][] board, String word) {
		if (board == null || board.length == 0 || board[0].length == 0 || word == null || word.equals("")) return false;
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++) if (search(board, word, i, j, 0)) return true;
		return false;
	}

	private static boolean search(char[][] board, String word, int i, int j, int matched) {
		if (matched == word.length()) return true;
		if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] != word.charAt(matched))
			return false;
		board[i][j] = '#';
		boolean result = search(board, word, i - 1, j, matched + 1) || search(board, word, i, j - 1, matched + 1) || search(board, word, i + 1, j, matched + 1) || search(board, word, i, j + 1, matched + 1);
		board[i][j] = word.charAt(matched);
		return result;

	}

	private static void dfs(char[][] board, int i, int j, Trie trie, HashSet<String> result, String s) {
		char c = board[i][j];
		if (c == '$') return;
		board[i][j] = '$';
		Trie t = trie.children[c - 'a'];
		if (t != null) {
			String ss = s + c;
			if (t.endOfWord) result.add(ss);
			if (i < board.length - 1) dfs(board, i + 1, j, t, result, ss);
			if (i > 0) dfs(board, i - 1, j, t, result, ss);
			if (j < board[0].length - 1) dfs(board, i, j + 1, t, result, ss);
			if (j > 0) dfs(board, i, j - 1, t, result, ss);
		}
		board[i][j] = c;
	}
}

class Trie {
	public final Trie[] children;
	public boolean endOfWord;

	public Trie() {
		endOfWord = false;
		children = new Trie[26];
		for (int i = 0; i < 26; ++i)
			children[i] = null;
	}

	void insert(String word) {
		Trie curr = this;
		for (char c : word.toCharArray()) {
			if (curr.children[c - 'a'] == null) curr.children[c - 'a'] = new Trie();
			curr = curr.children[c - 'a'];
		}
		curr.endOfWord = true;
	}
}
