package GFG;

import java.util.HashMap;
import java.util.Map;

public class LargestSubArrayWith0Sum {
	public static void main(String[] args) {
		int[] arr = {1, -3, 3, -3, 4 - 2, -4};
		System.out.println(maxLen(arr, arr.length));
	}

	static int maxLen(int[] arr, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		int sum = 0;
		int max_len = 0;
		for (int i = 0; i < n; i++) {
			sum += arr[i];
			if (sum == 0) max_len = i + 1;
			Integer prev_i = map.get(sum);
			if (prev_i != null) max_len = Math.max(max_len, i - prev_i);
			else map.put(sum, i);
		}
		return max_len;
	}
}
