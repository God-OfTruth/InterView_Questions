package gfg;

public class LongestBitonicSequence {
	public static void main(String[] args) {
		int[] ints = {1, 11, 2, 10, 4, 5, 2, 1};
		System.out.println(longestBitonicSequence(ints));
	}

	public static int longestBitonicSequence(int[] nums) {
		int i, j;
		int n = nums.length;
		int[] lis = new int[n];
		for (i = 0; i < n; i++)
			lis[i] = 1;
		for (i = 1; i < n; i++)
			for (j = 0; j < i; j++)
				if (nums[i] > nums[j] && lis[i] < lis[j] + 1)
					lis[i] = lis[j] + 1;
		int[] lds = new int[n];
		for (i = 0; i < n; i++)
			lds[i] = 1;
		for (i = n - 2; i >= 0; i--)
			for (j = n - 1; j > i; j--)
				if (nums[i] > nums[j] && lds[i] < lds[j] + 1)
					lds[i] = lds[j] + 1;
		int max = lis[0] + lds[0] - 1;
		for (i = 1; i < n; i++) {
			final int i1 = lis[i] + lds[i] - 1;
			if (i1 > max)
				max = i1;
		}
		return max;
	}
}
