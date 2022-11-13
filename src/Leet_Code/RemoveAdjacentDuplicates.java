package Leet_Code;

public class RemoveAdjacentDuplicates {
	static char LAST_REMOVED;

	public static void main(String[] args) {
		String s = "aaaaaaaaa";
		System.out.println(removeDuplicates(s));
	}

	public static String removeDuplicates(String s) {
		char[] stack = new char[s.length()];
		int i = 0;
		for (int j = 0; j < s.length(); j++) {
			char currentChar = s.charAt(j);
			if (i > 0 && stack[i - 1] == currentChar) {
				i--;
			} else {
				stack[i] = currentChar;
				i += 1;
			}
		}
		return new String(stack, 0, i);
	}

}
