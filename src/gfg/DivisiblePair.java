package gfg;

import java.util.HashMap;
import java.util.Objects;

public class DivisiblePair {
	public static void main(String[] args) {
		int[] nums = {2, 4, 1, 3};
		int k = 4;
		System.out.println(canPair(nums, k));
	}

	public static boolean canPair(int[] nums, int k) {
		if (nums.length % 2 == 1) return false;
		HashMap<Integer, Integer> hm = new HashMap<>();
		for (int num : nums) {
			int rem = ((num % k) + k) % k;
			if (!hm.containsKey(rem)) hm.put(rem, 0);
			hm.put(rem, hm.get(rem) + 1);
		}
		for (int num : nums) {
			int rem = ((num % k) + k) % k;
			if (2 * rem == k) {
				if (hm.get(rem) % 2 == 1) return false;
			} else if (rem == 0) {
				if (hm.get(rem) % 2 == 1) return false;
			} else if (!Objects.equals(hm.get(k - rem), hm.get(rem))) return false;
		}
		return true;
	}
}
