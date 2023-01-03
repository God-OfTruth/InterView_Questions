package leet_code;

public class MinimumSumPartition {
	public static void main(String[] args) {
		int[] arr = {1, 4};
		System.out.println(minDifference(arr, arr.length));
	}

	public static int minDifference(int[] arr, int n) {
		int totalSum = 0;
		for (int i : arr)
			totalSum += i;
		return findMinRec(arr, n, 0, totalSum);
	}

	private static int findMinRec(int[] arr, int i, int calculatedSum, int totalSum) {
		if (i == 0) return Math.abs((totalSum - calculatedSum) - calculatedSum);
		return Math.min(findMinRec(arr, i - 1, calculatedSum + arr[i - 1], totalSum), findMinRec(arr, i - 1, calculatedSum, totalSum));
	}
}
