package personal;

import java.util.ArrayList;
import java.util.List;

public class FindSigns {
	public static void main(String[] args) {
		int[] nums = {2, 3, 5, 5};
		List<Character> result = findSigns(nums);
		System.out.println(result.isEmpty() ? -1 : result);
	}

	public static List<Character> findSigns(int[] nums) {
		List<Character> signs = new ArrayList<>();
		if (backtrack(nums, 0, 0, signs)) {
			return signs;
		}
		return new ArrayList<>(); // Return empty if no solution found
	}

	private static boolean backtrack(int[] nums, int index, int sum, List<Character> signs) {
		if (index == nums.length) {
			return sum == 0;
		}

		// Try adding '+'
		signs.add('+');
		if (backtrack(nums, index + 1, sum + nums[index], signs)) return true;
		signs.remove(signs.size() - 1);

		// Try adding '-'
		signs.add('-');
		if (backtrack(nums, index + 1, sum - nums[index], signs)) return true;
		signs.remove(signs.size() - 1);

		return false; // No valid combination
	}
}
