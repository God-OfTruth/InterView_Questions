package leet_code;

public class _1863 {
	public static void main(String[] args) {
		System.out.println(subsetXORSum(new int[]{3, 4, 5, 6, 7, 8}));
	}

	public static int subsetXORSum(int[] nums) {
		int xorSum = 0;
		for (int num : nums) {
			xorSum |= num;
		}
		return (xorSum * (1 << (nums.length - 1)));
	}
}
