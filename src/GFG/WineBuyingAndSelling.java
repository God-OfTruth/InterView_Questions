package GFG;

public class WineBuyingAndSelling {
	static int N = 1000;
	static int[][] dp = new int[N][N];
	static int[][] sell = new int[N][N];

	public static void main(String[] args) {
		int[] arr = {5, -4, 1, -3, 1};
		System.out.println(wineSelling(arr, arr.length));
	}

	static long wineSelling(int[] arr, int n) {
//		for (int i = 0; i < N; i++)
//			for (int j = 0; j < N; j++)
//				dp[i][j] = -1;
//
//		return maxProfitUtil(Arr, 0, n - 1, n);
		long sum = 0L;
		long ans = 0L;
		for (int i : arr) {
			sum += i;
			ans += Math.abs(sum);
		}
		return ans;
	}

	static int maxProfitUtil(int[] price, int begin, int end, int n) {
		if (dp[begin][end] != -1) return dp[begin][end];
		int year = n - (end - begin);
		if (begin == end) return year * price[begin];
		int x = price[begin] * year + maxProfitUtil(price, begin + 1, end, n);
		int y = price[end] * year + maxProfitUtil(price, begin, end - 1, n);
		int ans = Math.max(x, y);
		dp[begin][end] = ans;
		if (x >= y) sell[begin][end] = 0;
		else sell[begin][end] = 1;
		return ans;
	}
}
