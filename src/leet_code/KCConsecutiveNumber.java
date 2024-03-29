package leet_code;

import java.util.*;

public class KCConsecutiveNumber {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 4, 4, 5, 6};
		int k = 4;
		System.out.println(isPossibleDivide(arr, k));
	}

	public static boolean isPossibleDivide(int[] nums, int k) {
		TreeMap<Integer, Integer> count = new TreeMap<>();

		for (final int num : nums)
			count.put(num, count.getOrDefault(num, 0) + 1);

		for (final int start : count.keySet()) {
			final int value = count.getOrDefault(start, 0);
			if (value > 0)
				for (int i = start; i < start + k; ++i) {
					count.put(i, count.getOrDefault(i, 0) - value);
					if (count.get(i) < 0)
						return false;
				}
		}
		return true;
	}

}
