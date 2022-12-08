package GFG;

public class ConvertOneToAnother {
	public static void main(String[] args) {
		String s = "#A#B#B#";
		String t = "A###B#B";
		System.out.println(isItPossible(s, t, s.length(), t.length()));
	}

	static int isItPossible(String s, String t, int m, int n) {
		if (m != n) return 0;
		int a = 0;
		int b = 0;
		for (int i = 0; i < n; i++) {
			if (s.charAt(i) == 'A') a++;
			else if (s.charAt(i) == 'B') b++;
			if (t.charAt(i) == 'A') a--;
			else if (t.charAt(i) == 'B') b--;
		}
		if (a != 0 || b != 0) return 0;
		int i = 0, j = 0;
		while (i < n && j < n) {
			while (i < n && s.charAt(i) == '#') i++;
			while (j < n && t.charAt(j) == '#') j++;
			if (i == n || j == n) break;
			if (s.charAt(i) == 'A')
				if (t.charAt(j) == 'A')
					if (j > i) return 0;
					else {
						i++;
						j++;
					}
				else return 0;
			else {
				if (t.charAt(j) == 'B')
					if (j < i) return 0;
					else {
						i++;
						j++;
					}
				else return 0;
			}
		}
		return 1;
	}

	private static int count(char[] str1, char c) {
		int count = 0;
		for (char temp : str1) if (c == temp) count++;
		return count;
	}
}
