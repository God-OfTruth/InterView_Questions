package leet_code;

public class JumpGame {
	public static void main(String[] args) {
		int[] nums = {2, 3, 1, 1, 4};
		System.out.println(canJump(nums));
	}

	public static boolean canJump(int[] nums) {
		int nums_len = nums.length - 1;
		for (int i = nums_len; i >= 0; --i) if (nums[i] + i >= nums_len) nums_len = i;
		return nums_len == 0;
	}
}
