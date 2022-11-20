package Leet_Code;

import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 0};
		System.out.println(Arrays.toString(plusOne(arr)));
	}

	public static int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--)
			if (digits[i] != 9) {
				digits[i]++;
				break;
			} else digits[i] = 0;
		if (digits[0] == 0) {
			int[] rst = new int[digits.length + 1];
			rst[0] = 1;
			return rst;
		}
		return digits;
	}
}
