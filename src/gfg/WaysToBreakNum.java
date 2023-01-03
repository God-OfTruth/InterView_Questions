package gfg;

public class WaysToBreakNum {
	private static final long mod = 1000000007;

	public static void main(String[] args) {
		System.out.println(waysToBreakNumber(2));
	}

	static int waysToBreakNumber(int N) {
		return (int) ((3 * (long) N + (((long) N - 1) * ((long) N - 2)) / 2) % mod);
	}
}
