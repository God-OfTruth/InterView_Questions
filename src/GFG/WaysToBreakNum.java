package GFG;

public class WaysToBreakNum {
	private static final long mod = 1000000007;

	public static void main(String[] args) {
		System.out.println(waysToBreakNumber(2));
	}

	static int waysToBreakNumber(int N) {
		long n = N;
		return (int) ((3 * n + ((n - 1) * (n - 2)) / 2) % mod);
	}
}
