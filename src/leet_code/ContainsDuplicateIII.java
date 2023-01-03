package leet_code;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		int[] nums = {1, 5, 9, 1, 5, 9};
		System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
	}

	public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		boolean ans = false;
		for (int i = 0; i < nums.length; i++)
			for (int j = i + 1; j < nums.length; j++) {
				if (Math.abs(i - j) > indexDiff) continue;
				if (Math.abs(nums[i] - nums[j]) <= valueDiff) {
					ans = true;
					break;
				}
			}
		return ans;
	}

}