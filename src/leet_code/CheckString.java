package leet_code;

public class CheckString {
	public static void main(String[] args) {
		String s = "aaabbbb";
		System.out.println(checkString(s));
	}

	public static boolean checkString(String s) {
		boolean flag = false;
		for (char c: s.toCharArray()){
			if (c == 'b') flag = true;
			if (flag && c == 'a') return false;
		}
		return true;
	}
}
