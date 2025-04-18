package personal;

import java.util.*;

public class ServerSelection {
	public static int maxServers(int[] powers) {
		Map<Integer, Integer> freq = new HashMap<>();
		for (int power : powers) {
			freq.put(power, freq.getOrDefault(power, 0) + 1);
		}

		int maxCount = 0;

		// Get all unique sorted keys
		List<Integer> unique = new ArrayList<>(freq.keySet());
		Collections.sort(unique);

		for (int curr : unique) {
			int count = freq.get(curr);

			// Try a window of curr + curr+1
			if (freq.containsKey(curr + 1)) {
				count += freq.get(curr + 1);
				maxCount = Math.max(maxCount, count);
				count -= freq.get(curr + 1); // reset
			}

			// Try window of curr-1, curr, curr+1
			int triCount = freq.getOrDefault(curr - 1, 0) + freq.get(curr) + freq.getOrDefault(curr + 1, 0);
			maxCount = Math.max(maxCount, triCount);
		}

		return maxCount;
	}

	public static void main(String[] args) {
		int[] powers4 = {3, 7, 5, 1, 5};        // Expected Output: 2 (all 1s are valid)
		int[] powers5 = {2, 2, 3, 2, 1, 2, 2};        // Expected Output: 7
		int[] powers6 = {7,2,2,3,2,1,2,2};        // Expected Output: 7

		System.out.println(maxServers(powers4)); // Output: 2
		System.out.println(maxServers(powers5)); // Output: 7
		System.out.println(maxServers(powers6)); // Output: 7
	}
}
