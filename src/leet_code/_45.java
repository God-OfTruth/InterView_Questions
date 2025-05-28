package leet_code;

public class _45 {
	public static void main(String[] args) {
		System.out.println(jump(new int[]{2, 3, 1, 1, 4}));
	}

	public static int jump(int[] nums) {
		int ans = 0;
		int end = 0;
		int farthest = 0;
		for (int i = 0; i < nums.length - 1; i++) {
			farthest = Math.max(farthest, i + nums[i]);
			if (farthest >= nums.length - 1) {
				ans++;
				break;
			}
			if (i == end) {
				ans++;
				end = farthest;
			}
		}
		return ans;
	}
}
