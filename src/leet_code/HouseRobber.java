package leet_code;

public class HouseRobber {
	public static void main(String[] args) {
		int[] nums = {2, 7, 9, 3, 1};
		System.out.println(rob(nums));
	}

	public static int rob(int[] nums) {
		int prev = 0, cur = 0, ans = 0;
		for (int num : nums) {
			ans = Math.max(cur, prev + num);
			prev = cur;
			cur = ans;
		}
		return ans;
	}
}
