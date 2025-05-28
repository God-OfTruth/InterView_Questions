package leet_code;

public class _53 {
	public static void main(String[] args) {
		System.out.println(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
	}

	public static int maxSubArray(int[] nums) {
		int maxSum = Integer.MIN_VALUE;
		int sum = 0;

		for (int num : nums) {
			sum += num;
			if (sum > maxSum) {
				maxSum = sum;
			}
			if (sum < 0) {
				sum = 0;
			}
		}
		return maxSum;
	}
}
