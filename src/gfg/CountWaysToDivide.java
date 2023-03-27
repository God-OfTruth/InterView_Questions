package gfg;

public class CountWaysToDivide {
	public static void main(String[] args) {
		int n = 8;
		int k = 4;
		System.out.println(countWaysToDivide(n, k));
	}

	public static int countWaysToDivide(int n, int k) {
		return count(n, k, 1, new Integer[n + 1][k + 1][n + 1]);
	}

	public static int count(int sum, int k, int previousElement, Integer[][][] dp) {
		if (k == 0 && sum == 0) return 1;
		if (k == 0 || sum <= 0) return 0;
		if (dp[sum][k][previousElement] != null) return dp[sum][k][previousElement];
		int ans = 0;
		for (int i = previousElement; i <= sum; i++) ans += count(sum - i, k - 1, i, dp);
		return dp[sum][k][previousElement] = ans;
	}
}
