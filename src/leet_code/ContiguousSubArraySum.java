package leet_code;

import java.util.HashMap;

public class ContiguousSubArraySum {
	public static void main(String[] args) {
		int[] arr = {23, 2, 6, 4, 7};
		System.out.println(checkSubArraySum(arr, 13));
	}

	public static boolean checkSubArraySum(int[] nums, int k) {
		HashMap<Integer, Integer> remain = new HashMap<>();
		int sum = 0;
		remain.put(0, -1);
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (k == 0) if (remain.containsKey(sum)) {
				if (remain.get(sum) != i - 1 || i == 1) return true;
			} else remain.put(sum, i);
			else {
				int re = sum % k;
				if (remain.containsKey(re)) {
					if (remain.get(re) != i - 1) return true;
				} else remain.put(re, i);
			}
		}
		return false;
	}
}
