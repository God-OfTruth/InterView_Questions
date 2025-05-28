package leet_code;

public class _560 {
	public static void main(String[] args) {
		System.out.println(subArraySum(new int[]{1, 1, 1}, 2));
	}

	public static int subArraySum(int[] nums, int k) {
		int count = 0;
		for (int i = 0; i < nums.length; i++) {
			int sum = 0;
			for (int j = i; j < nums.length; j++) {
				sum += nums[j];
				if (sum == k) {
					count++;
				}
			}
		}
		return count;
	}
}
