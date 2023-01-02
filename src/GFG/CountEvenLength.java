package GFG;

public class CountEvenLength {
	static final long MOD = (long) (Math.pow(10, 9) + 7);

	public static void main(String[] args) {
		int n = 1;
		System.out.println(compute_value(n));
	}

	public static int compute_value(int n) {
		int ans = 1;
		long nCr = 1;
		for (int r = 1; r <= n; r++) {
			nCr = ((nCr * (n + 1 - r)) % MOD) * inv(r) % MOD;
			ans = (int) ((ans + (nCr * nCr) % MOD) % MOD);
		}
		return ans;
	}

	static long inv(long a) {
		if (a == 1) return 1;
		return (MOD - ((MOD / a) * inv(MOD % a)) % MOD + MOD) % MOD;
	}
}
