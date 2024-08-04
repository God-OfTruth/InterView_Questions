package personal;

import java.util.*;

public class test {
	public static void main(String[] args) {
		for (int i = 1; i <= 5; i++) {
			for (int j = i; j <= 5; j++) {
				System.out.print(j + " ");
			}
			for (int j = 1; j < i; j++) {
				System.out.print(" ");
			}
			System.out.println();
		}
		System.out.println(
				topOfMountain(
						new int[]{1, 3, 4, 6, 10, 23, 33, 50, 21, 20, 19, 5, 0}, 0, 12)
		);

		System.out.println(
				solve(
						Arrays.asList(
								Arrays.asList("0", "China"),
								Arrays.asList("1", "Cuba"),
								Arrays.asList("2", "-1"),
								Arrays.asList("3", "Cuba"),
								Arrays.asList("4", "-1"),
								Arrays.asList("5", "-1"),
								Arrays.asList("6", "Cuba"),
								Arrays.asList("7", "Germany"),
								Arrays.asList("8", "Germany"),
								Arrays.asList("9", "China")
						)
				)
		);

		System.out.println(
				solve(4, Arrays.asList(0, 1, 1, 0))
		);
	}

	public static int topOfMountain(int[] hs, int L, int H) {
		if (L == H) {
			return hs[L];
		}
		if (H == L + 1) {
			return Math.max(hs[L], hs[H]);
		}

		int mid = (L + H) / 2;

		if (hs[mid] > hs[mid + 1] && hs[mid] > hs[mid - 1]) {
			return hs[mid];
		}

		if (hs[mid] > hs[mid + 1] && hs[mid] < hs[mid - 1]) {
			return topOfMountain(hs, L, mid - 1);
		} else {
			return topOfMountain(hs, mid + 1, H);
		}
	}

	public static List<List<String>> solve(List<List<String>> g) {
		Map<String, Integer> countryCount = new TreeMap<>();

		for (List<String> row : g) {
			String country = row.get(1).trim();
			if (!country.equals("-1")) {
				countryCount.put(country, countryCount.getOrDefault(country, 0) + 1);
			}
		}

		List<List<String>> result = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : countryCount.entrySet()) {
			result.add(Arrays.asList(entry.getKey(), String.valueOf(entry.getValue())));
		}

		return result;
	}

	public static int solve(int p, List<Integer> a) {
		int collected = 0;
		int N = a.size();
		int start = p - 1;  // Convert 1-based index to 0-based

		// Collect garbage to the left
		for (int distance = 1; distance < N; distance++) {
			int leftIndex = start - distance;
			if (leftIndex < 0) break;  // Out of bounds
			if (a.get(leftIndex) == 1) {
				collected++;
				continue; // Once found, continue to next distance
			}
		}

		// Collect garbage to the right
		for (int distance = 1; distance < N; distance++) {
			int rightIndex = start + distance;
			if (rightIndex >= N) break;  // Out of bounds
			if (a.get(rightIndex) == 1) {
				collected++;
				continue; // Once found, continue to next distance
			}
		}

		return collected;
	}
}