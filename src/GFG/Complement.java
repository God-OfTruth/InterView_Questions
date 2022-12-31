package GFG;

import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Complement {
	public static void main(String[] args) {
		String str = "01";
		System.out.println(findRange(str, str.length()));
	}

	static Vector<Integer> findRange(String str, int n) {
		int count = 0, l = -1, r = -1, max = 0, ansL = -1, ansR = -1;
		int i = 0;
		for (char c : str.toCharArray()) {
			i++;
			if (c == '0') count++;
			else {
				count--;
				if (count < 0) {
					count = 0;
					l = -1;
				}
			}
			if (count == 1 && l == -1) l = i;
			if (count > max) {
				max = count;
				ansL = l;
				ansR = i;
			}
		}
		if (ansL == -1) return new Vector<>(List.of(-1));
		return new Vector<>(List.of(ansL, ansR));
	}
}
