package leet_code;

public class _485 {
	public static void main(String[] args) {
		System.out.println(findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
	}

	public static int findMaxConsecutiveOnes(int[] nums) {
		int ans = 0;
		int temp = 0;
		for (int num : nums) {
			if (num == 1) {
				temp++;
			} else {
				ans = Math.max(temp, ans);
				temp = 0;
			}
		}
		return Math.max(ans, temp);
	}
}
