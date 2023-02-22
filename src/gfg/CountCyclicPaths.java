package gfg;

public class CountCyclicPaths {
	public static void main(String[] args) {
		int n = 2;
		System.out.println(countPaths(n));
	}

	public static int countPaths(int N) {
		int m = (int) (Math.pow(10, 9) + 7);
		long o = 0, a = 1, b = 1, c = 1;
		for (int i = 2; i <= N; i++) {
			long way2origin = (a + b + c) % m;
			long ways2a = (o + b + c) % m;
			long ways2b = (o + a + c) % m;
			long ways2c = (o + b + a) % m;
			o = way2origin;
			a = ways2a;
			b = ways2b;
			c = ways2c;
		}
		return (int) o;
	}
}
