package leet_code;

import java.util.ArrayList;
import java.util.Arrays;

public class PlusOne {
	public static void main(String[] args) {
		int[] arr = {1, 3, 5, 0};
		System.out.println(Arrays.toString(plusOne(arr)));
		ArrayList<Integer> list = new ArrayList<>(Arrays.asList(9, 6, 9));
		System.out.println(increment(list, list.size()));
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

	static ArrayList<Integer> increment(ArrayList<Integer> arr, int N) {
		if (N == 1) return new ArrayList<>(Arrays.asList(1, 0));
		for (int i = N - 1; i >= 0; i--)
			if (arr.get(i) != 9) {
				arr.set(i, arr.get(i) + 1);
				break;
			} else arr.set(i, 0);
		if (arr.get(0) == 0) {
			for (int i = 0; i < N; i++) arr.set(i, 0);
			arr.set(0, 1);
			return arr;
		}
		return arr;
	}
}
