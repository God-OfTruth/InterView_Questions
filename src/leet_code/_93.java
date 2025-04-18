package leet_code;

import java.util.ArrayList;
import java.util.List;

public class _93 {
	public static void main(String[] args) {
		System.out.println(restoreIpAddresses("25525511135"));
	}

	public static List<String> restoreIpAddresses(String s) {
		List<String> res = new ArrayList<>();

		if(s.length() > 12){
			return res;
		}

		rec(0, 0, "", res, s);
		return res;
	}

	static void rec(int i, int dots, String currIp, List<String> res, String s){
		if (dots == 4 && i == s.length()) {
			res.add(currIp.substring(0, currIp.length() - 1));
			return;
		}
		if (dots > 4) {
			return;
		}
		for (int j = i; j < Math.min(i + 3, s.length()); j++) {
			if (Integer.parseInt(s.substring(i, j + 1)) <= 255 && (i == j || s.charAt(i) != '0')) {
				rec(j + 1, dots + 1, currIp + s.substring(i, j + 1) + '.', res, s);
			}
		}

	}
}
