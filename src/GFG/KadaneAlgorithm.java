package GFG;

import java.util.Arrays;

public class KadaneAlgorithm {
	public static void main(String[] args) {
		int[] arr = {-1,-2, -9,8, 0};
		System.out.println(maxSubArraySum(arr, arr.length));
	}

	static long maxSubArraySum(int[] arr, int n){
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
