package GFG;

import java.util.HashMap;
import java.util.Map;

public class ZeroSumSubArrays {
	public static void main(String[] args) {
		long[] arr = {0, 0, 5, 5, 0, 0};
		System.out.println(findSubArray(arr, arr.length));
	}

	public static long findSubArray(long[] arr, int n) {
		Map<Long, Long> map = new HashMap<>();
		map.put(0L, 1L);
		long sum = 0, ans = 0;
		for (long i : arr) {
			sum += i;
			if (map.containsKey(sum)) ans += map.get(sum);
			map.put(sum, map.getOrDefault(sum, 0L) + 1);
		}
		return ans;
	}
}
