package Leet_Code;

public class BinarySearch {
	public static void main(String[] args) {
		int[] nums = {-1, 0, 3, 5, 9, 12};
		int target = 2;
		System.out.println(search(nums, target));
	}

	public static int search(int[] nums, int target) {
		int start = 0;
		int last = nums.length - 1;
		while (start <= last) {
			int mid = (last + start) / 2;
			if (nums[mid] == target) return mid;
			if (nums[mid] > target) last = mid - 1;
			else start = mid + 1;
		}
		return -1;
	}
}
