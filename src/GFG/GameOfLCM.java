package GFG;

public class GameOfLCM {
	public static void main(String[] args) {
		System.out.println(maxGcd(18));
	}

	static long maxGcd(int n) {
		return Math.max(solve(n), solve(n - 1));
	}

	static long solve(int n) {
		long a1 = (long) n * (n - 1);
		int include = 0;
		for (long i = n - 2; i >= 1; i--) {
			long g = gcd(a1, i);
			if (g == 1) {
				a1 *= i;
				include++;
			}
			if (include == 2) return a1;
		}
		return a1;
	}

	static long gcd(long a, long b) {
		if (a == 0) return b;
		return gcd(b % a, a);
	}
}
