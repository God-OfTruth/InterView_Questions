package Leet_Code;

public class ContainsDuplicateIII {
	public static void main(String[] args) {
		int[] nums = {1,5,9,1,5,9};
		System.out.println(containsNearbyAlmostDuplicate(nums, 2, 3));
	}

	/*
	 * Find a pair of indices (i, j) such that:
	 *  i != j,
	 *  abs(i - j) <= indexDiff.
	 *  abs(nums[i] - nums[j]) <= valueDiff, and
	 * */
//	public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
//		boolean ans = false;
//		for (int i = 0; i < nums.length; i++) {
//			int j = i + indexDiff;
//			if (j >= nums.length) break;
//			int iDiff = Math.abs(i - j);
//			if (iDiff > indexDiff) continue;
//			int vDiff = Math.abs(nums[i] - nums[j]);
//			if (vDiff <= valueDiff) {
//				ans = true;
//				break;
//			}
//		}
//		return ans;
//	}
	/*
	 * Find a pair of indices (i, j) such that:
	 *  i != j,
	 *  abs(i - j) <= indexDiff.
	 *  abs(nums[i] - nums[j]) <= valueDiff, and
	 * */
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
		boolean ans = false;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (Math.abs(i - j) > indexDiff) continue;
				if (Math.abs(nums[i] - nums[j]) <= valueDiff){
					ans = true;
					break;
				}
			}
		}
		return ans;
	}

}