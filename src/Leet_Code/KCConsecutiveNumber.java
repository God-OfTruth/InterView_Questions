package Leet_Code;

import java.util.*;

public class KCConsecutiveNumber {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 3, 4, 4, 5, 6};
		int k = 4;
		System.out.println(isPossibleDivide(arr, k));
	}

	//	public static boolean isPossibleDivide(int[] nums, int k) {
//		Map<Integer, Integer> count = new HashMap<>();
//
//		for (int h : nums)
//			if (count.containsKey(h))
//				count.put(h, count.get(h) + 1);
//			else
//				count.put(h, 1);
//
//		for (Map.Entry<Integer, Integer> c : count.entrySet()) {
//			int cur = c.getKey();
//			int n = c.getValue();
//			if (n > 0)
//				for (int i = 1; i < k; ++i) {
//					if (!count.containsKey(cur + i))
//						return false;
//					count.put(cur + i, count.get(cur + i) - n);
//					if (count.get(cur + i) < 0)
//						return false;
//				}
//		}
//		return true;
//	}
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
