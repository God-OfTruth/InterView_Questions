package leet_code;

public class DetermineHalvesStringsAlike {
	public static void main(String[] args) {
		System.out.println(halvesAreAlike("textbook"));
	}

	public static boolean halvesAreAlike(String s) {
		s = s.toLowerCase();
		String a = s.substring(0, s.length() / 2);
		String b = s.substring(s.length() / 2);
		int x = 0;
		for (char c : a.toCharArray()) if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') x++;
		for (char c : b.toCharArray()) if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') x--;
		return x == 0;
	}
}
