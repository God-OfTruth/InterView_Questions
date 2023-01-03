package gfg;

public class CountNumberOfFullBinaryTrees {
	public static void main(String[] args) {
		int[] arr = {2, 3, 4, 6};
		System.out.println(numoffbt(arr, arr.length));
	}

	public static int numoffbt(int[] arr, int n) {
		int mod = 1000000007;
		int min = 100001, max = 1;
		for (int  i : arr) {
			max = Math.max(max, i);
			min = Math.min(min, i);
		}
		int[] dp = new int[max + 1];
		for (int i : arr) dp[i] = 1;
		int ans = 0;
		for (int i = min; i <= max; i++) {
			if (dp[i] == 0) continue;
			for (int j = i + i; j <= max && j / i <= i; j += i) {
				if (dp[j] == 0) continue;
				final int i1 = dp[i] * dp[j / i];
				dp[j] += i1;
				if (i != j / i) dp[j] += i1;
			}
			ans = (ans + dp[i]) % mod ;
		}
		return ans % mod;
	}
}
