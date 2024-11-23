package leet_code;

public class _55_JumpGame {
	public static void main(String[] args) {
		System.out.println(canJump(new int[]{3, 2, 1, 0, 4}));
	}

	public static boolean canJump(int[] nums) {
		int end = nums.length - 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			if (nums[i] + i >= end) {
				end = i;
			}
		}
		return end == 0;
	}
}
