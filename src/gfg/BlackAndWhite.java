package gfg;

public class BlackAndWhite {
	public static void main(String[] args) {
		System.out.println(numOfWays(2, 2));
	}

	static long numOfWays(int n, int m) {
		long mod = (long) (Math.pow(10, 9) + 7L);
		long total = (((long) m * n) % mod * ((long) m * n - 1) % mod);

		if (n >= 1 && m >= 2) total -= 4L * (n - 1) * (m - 2);
		if (m >= 1 && n >= 2) total -= 4L * (m - 1) * (n - 2);
		return total;
	}
}
