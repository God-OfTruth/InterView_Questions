package gfg;

public class MaxSubArrayProduct {
	public static void main(String[] args) {
		int[] ints = {2, 3, -2, 4};
		System.out.println(maxProduct(ints));
	}
/*
* Need to implement the solution
* */
	static int maxProduct(int[] arr) {
		int max = Integer.MIN_VALUE, maxTillNow = 0;

		for (int j : arr) {
			maxTillNow = maxTillNow + j;
			if (max < maxTillNow)
				max = maxTillNow;
			if (maxTillNow < 0)
				maxTillNow = 0;
		}
		return max;
	}
}
