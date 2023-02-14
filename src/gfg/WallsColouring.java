package gfg;

public class WallsColouring {
	public static void main(String[] args) {
		int[][] colors = {{1, 2, 3}, {1, 4, 6}};
		System.out.println(minCost(colors, colors.length));
	}

	static int minCost(int[][] colors, int n) {
		int[][] dp = new int[n][3];

		dp[0][0] = colors[0][0];
		dp[0][1] = colors[0][1];
		dp[0][2] = colors[0][2];

		for (int i = 1; i < n; i++) {
			dp[i][0] = colors[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
			dp[i][1] = colors[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
			dp[i][2] = colors[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
		}

		return Math.min(Math.min(dp[n - 1][0], dp[n - 1][1]), dp[n - 1][2]);
	}
}
