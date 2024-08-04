package personal;

import java.util.*;

public class PairFinding {
	static long minCost(int n, long[] cat, long[] pri) {
		// Create a map to store the prices per category
		Map<Long, Long> prices = new HashMap<>();

		// Iterate through the items and calculate the price per category
		for (int i = 0; i < n; i++) {
			long category = cat[i];
			long price = pri[i];

			// If category already exists, add the price to the existing value
			// If category is new, set the price
			prices.put(category, prices.getOrDefault(category, 0L) + price);
		}

		// Sort the prices map by category
		List<Map.Entry<Long, Long>> sortedPrices = new ArrayList<>(prices.entrySet());
		sortedPrices.sort(Map.Entry.comparingByKey());

		// Calculate the minimum cost
		long ans = 0;
		long itemCount = 0;

		for (Map.Entry<Long, Long> entry : sortedPrices) {
			long category = entry.getKey();
			long price = entry.getValue();

			itemCount++; // Increment the item count for each category

			// Add the price multiplied by the item count to the total cost
			ans += price * itemCount;
		}

		return ans;
	}


	public static void main(String[] args) {
		int n = 4;
		long[] cat = {3, 1, 2, 3};
		long[] pri = {2, 1, 4, 4};
		System.out.println(minCost(n, cat, pri)); // Output: 29
	}
}

