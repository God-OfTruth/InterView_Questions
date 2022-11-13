package Leet_Code;

public class BackspaceStringCompare {
	public static void main(String[] args) {
		String s = "y#fo##f";
		String t = "y#f#o##f";
		System.out.println(backspaceCompare(s, t));
	}

	public static boolean backspaceCompare(String s, String t) {
		return backspace(s).equals(backspace(t));
	}

	public static String backspace(String s) {
		StringBuilder builder = new StringBuilder();
		int j = 0;
		for (int i = 0; i < s.length(); i++) {
			if (i==0 && s.charAt(i) == '#') {
				continue;
			}
			if (j > 0 && s.charAt(i) == '#') {
				builder.deleteCharAt(j - 1);
				j--;
			} else {
				j++;
				builder.append(s.charAt(i));
			}
		}
		String str = builder.toString();
		if (!isCheck(str)) {
			return backspace(str);
		}
		return str;
	}

	public static boolean isCheck(String s){
		for (char c: s.toCharArray()){
			if (c == '#') return false;
		}
		return true;
	}
}
