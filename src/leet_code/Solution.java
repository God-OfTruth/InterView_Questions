package leet_code;

public class Solution {
	public static void main(String[] args) {
		System.out.println(findMaximumNum("3435335", 3));
	}

	static String max = "0";

	static String swap(String str, int i, int j) {
		char ith = str.charAt(i);
		char jth = str.charAt(j);
		String left = str.substring(0, i);
		String mid = str.substring(i + 1, j);
		String right = str.substring(j + 1);
		return left + jth + mid + ith + right;
	}

	static void helper(String str, int k) {
		if (Integer.parseInt(max) < Integer.parseInt(str)) max = str;
		if (k == 0) return;
		for (int i = 0; i < str.length() - 1; i++)
			for (int j = i + 1; j < str.length(); j++)
				if (str.charAt(i) < str.charAt(j)) {
					String s = swap(str, i, j);
					helper(s, k - 1);
				}
	}

	//Function to find the largest number after k swaps.
	public static String findMaximumNum(String str, int k) {
		//  max = Integer.MIN_VALUE;
		helper(str, k);
		return max;
	}
}
