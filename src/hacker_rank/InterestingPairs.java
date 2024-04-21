package hacker_rank;

/**
 * A mathematics: professor in a Senior Secondary
 * High School decided to evaluate students for the Teachers Assessment based on their problem-solving skills.
 * Given an array of integers arr, an integer, sumVal, the task is to pair the elements in arr into interesting pairs.
 * Find the number of interesting pairs in the array. An unordered pair (i, j) is defined to be interesting if
 * |arr[i],- arr[j]| + |arr[i] + arr[j]| = sumVal (i.e., the sum of absolute.
 * difference and absolute sum at the values in respective indices is equal to sumVal). The goal is to find the number of interesting pairs in the array.
 */

public class InterestingPairs {
	public static int countInterestingPairs(int[] arr, int sumVal) {
		int count = 0;
		int n = arr.length;

		// Iterate through all pairs of elements
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				int absoluteDiff = Math.abs(arr[i] - arr[j]);
				int absoluteSum = Math.abs(arr[i]) + Math.abs(arr[j]);

				// Check if the condition holds true
				if (absoluteDiff + absoluteSum == sumVal) {
					count++;
				}
			}
		}

		return count;
	}

	public static void main(String[] args) {
		int[] arr = {1, 3, 2, 0};
		int sumVal = 2;
		int result = countInterestingPairs(arr, sumVal);
		System.out.println("Number of interesting pairs: " + result);
	}
}
