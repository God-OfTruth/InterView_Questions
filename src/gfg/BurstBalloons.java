package gfg;

public class BurstBalloons {
	public static void main(String[] args) {
		int[] arr = {3, 1, 5, 8};
		System.out.println(maxCoins(arr.length, arr));
	}

	public static int maxCoins(int N, int[] arr) {
		int[] B = new int[N + 2];
		B[0] = B[N + 1] = 1;

		if (N >= 0) System.arraycopy(arr, 0, B, 1, N);

		int[][] dp = new int[N + 2][N + 2];

		for (int length = 1; length < N + 1; length++)
			for (int left = 1; left < N - length + 2; left++) {
				int right = left + length - 1;
				for (int last = left; last < right + 1; last++)
					dp[left][right] = Math.max(dp[left][right], dp[left][last - 1] + B[left - 1] * B[last] * B[right + 1] + dp[last + 1][right]);
			}
		return dp[1][N];
	}
}