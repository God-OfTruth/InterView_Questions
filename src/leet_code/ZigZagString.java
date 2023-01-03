package leet_code;

import java.util.ArrayList;
import java.util.List;

public class ZigZagString {
	public static void main(String[] args) {
		String s = "PAYPALISHIRING";
		int numRows = 3;
		System.out.println(convert(s, numRows));
	}

	public static String convert(String s, int numRows) {
		if (numRows == 1) return s;
		List<StringBuilder> list = new ArrayList<>();
		for (int i = 0; i < numRows; i++) list.add(new StringBuilder());
		int idx = 0;
		boolean downDirection = false;
		for (char c : s.toCharArray()) {
			list.get(idx).append(c);
			if (idx == 0 || idx == numRows - 1) downDirection = !downDirection;
			idx += downDirection ? 1 : -1;
		}
		StringBuilder result = new StringBuilder();
		for (StringBuilder sb : list) result.append(sb.toString());
		return result.toString();
	}

	/*
	 * p     		h
	 * a    		s	i
	 * y		i		r
	 * p	l			i	g
	 * a				n
	 * */

}
