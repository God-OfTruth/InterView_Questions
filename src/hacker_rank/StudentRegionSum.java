package hacker_rank;

import java.util.List;

public class StudentRegionSum {

	public static int calculateTotalRegion(List<Integer> heights) {
		int n = heights.size();
		int sum = 0;

		// Iterate through each student
		for (int i = 0; i < n; i++) {
			int left = i;
			int right = i;

			// Find the left boundary of the region
			while (left > 0 && heights.get(left - 1) > heights.get(i)) {
				left--;
			}

			// Find the right boundary of the region
			while (right < n - 1 && heights.get(right + 1) > heights.get(i)) {
				right++;
			}

			// Calculate the length of the region for the current student
			int regionLength = right - left + 1;

			// Add the length of the region to the sum
			sum += regionLength;
		}

		return sum;
	}

	public static void main(String[] args) {
		List<Integer> heights = List.of(3, 5, 6);
		System.out.println("Sum of regions: " + calculateTotalRegion(heights));
	}
}
