package gfg;

import java.util.Arrays;
import java.util.concurrent.atomic.AtomicInteger;

public class GoodStones {

	static int[] dp;

	public static void main(String[] args) {
		int[] arr = {1, 0, -3, 0, -5, 0};
		System.out.println(goodStones(arr.length, arr));
	}

	public static int goodStones(int n, int[] arr) {
		dp = new int[n];
		Arrays.fill(dp, -1);
		for (int i = 0; i < n; i++) if (dp[i] == -1) dp[i] = good(i, arr);
		int ans = 0;
		for (int value : dp) if (value == 1) ans++;
		return ans;
	}

	static int good(int i, int[] arr) {
		if (i < 0 || i >= arr.length) return 1;
		if (dp[i] != -1) return dp[i];
		dp[i] = 0;
		return dp[i] = good(i + arr[i], arr);
	}
}
