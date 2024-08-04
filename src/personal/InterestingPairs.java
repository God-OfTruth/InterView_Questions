package personal;

import java.util.HashMap;
import java.util.Map;

public class InterestingPairs {
	public static int countInterestingPairs(int[] arr, int sumVal) {
		int count = 0;

		// Map to store the frequency of elements
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : arr) {
			freqMap.put(num, freqMap.getOrDefault(num, 0) + 1);
		}

		// Iterate through each unique element in the map
		for (int num : freqMap.keySet()) {
			int diff = sumVal - 2 * num;
			if (freqMap.containsKey(diff)) {
				count += freqMap.get(num) * freqMap.get(diff);
				if (num == diff) { // If the element is the same, subtract the number of pairs with the same element
					count -= freqMap.get(num);
				}
			}
		}

		// Divide the count by 2 as each pair is counted twice
		return count / 2;
	}


	public static void main(String[] args) {
		int[] arr = {1, 4, -1, 2};
		int sumVal = 4;
		System.out.println(countInterestingPairs(arr, sumVal)); // Output: 2
	}
}

