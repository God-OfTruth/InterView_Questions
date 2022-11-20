package GFG;

public class MaximumCutSegment {
	public static void main(String[] args) {
		int n = 4, x = 2, y = 1, z = 1;
		System.out.println(get(n, x, y, z));
	}

	static int get(int n, int x, int y, int z) {
		if (n == 1) return n;
		int[] dp = new int[n + 1];
		//   for(int i = 0 ; i <=n ; i++) dp[i] = Integer.MIN_VALUE;
		dp[0] = 1;

		for (int i = 1; i <= n; i++) {
			if (i - x >= 0) dp[i] = Math.max(dp[i - x] + dp[i], dp[i]);
			if (i - y >= 0) dp[i] = Math.max(dp[i - y] + dp[i], dp[i]);
			if (i - z >= 0) dp[i] = Math.max((dp[i - z] + dp[i]), dp[i]);
		}
		//   if(dp[n] < 0) return 0;
		return dp[n];
	}
}
