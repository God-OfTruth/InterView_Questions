package gfg;

import java.util.Arrays;

public class FindUniqueElementInArray {
	public static void main(String[] args) {
		int[] nums = {1, 2, 5, 2, 5, 1, 3, 2, 2, 3, 6, 5,7, 5};
		System.out.println(findUnique(nums));
		System.out.println(Arrays.toString(findTwoUnique(nums)));
	}

	private static int[] findTwoUnique(int[] nums) {
		int sum = 0;
		for (int i : nums) sum = (sum ^ i);
		sum = (sum & -sum);
		int num1 = 0;
		int num2 = 0;
		for (int i : nums)
			if ((i & sum) > 0) num1 = (num1 ^ i);
			else num2 = (num2 ^ i);
		return new int[]{num1, num2};
	}

	private static int findUnique(int[] nums) {
		int sum = 0;
		for (int i : nums) sum = sum ^ i;
		return sum;
	}
}
