package gfg;

public class MobileNumericKeypad {

	public static void main(String[] args) {
		long s = System.currentTimeMillis();
		System.out.println(getCount(5));
		long e = System.currentTimeMillis();
		System.out.println(s - e);
	}

	public static long getCount(int n) {
		int[][] data = {
				{0, 8},
				{1, 2, 4},
				{1, 2, 3, 5},
				{2, 3, 6},
				{1, 4, 5, 7},
				{2, 5, 8, 4, 6},
				{3, 5, 6, 9},
				{4, 7, 8},
				{5, 7, 8, 9, 0},
				{6, 8, 9}};

		if (n == 1) return 10;
		long[][] dp = new long[n + 1][10];

		for (int i = 1; i <= n; i++)
			for (int j = 0; j <= 9; j++)
				if (i == 1) dp[i][j] = 1;
				else for (int prev : data[j]) dp[i][j] += dp[i - 1][prev];
		long sum = 0;
		for (int i = 0; i <= 9; i++) sum += dp[n][i];
		return sum;
	}
}
