package leet_code;

public class CheckStringsEqual {
	public static void main(String[] args) {
		String[] word1 = {"ab", "c"};
		String[] word2 = {"av", "bc"};
		System.out.println(arrayStringsAreEqual(word1, word2));
	}
	public static boolean arrayStringsAreEqual(String[] word1, String[] word2) {
		StringBuilder b1 = new StringBuilder();
		StringBuilder b2 = new StringBuilder();
		for (String s: word1)
			b1.append(s);
		for (String s: word2)
			b2.append(s);
		if (b1.length() != b2.length()) return false;
		for (int i=0; i< b1.length(); i++) if (b1.charAt(i) != b2.charAt(i)) return false;
		return true;
	}
}
