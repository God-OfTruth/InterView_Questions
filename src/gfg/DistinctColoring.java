package gfg;

public class DistinctColoring {
	public static void main(String[] args) {
		int[] r = {1, 1, 1};
		int[] g = {2, 2, 2};
		int[] b = {3, 3, 3};
		System.out.println(distinctColoring(3, r, g, b));
	}

	public static long distinctColoring(int n, int[] r, int[] g, int[] b) {
		long x = r[0];
		long y = g[0];
		long z = b[0];
		for (int i = 1; i < n; i++) {
			long x1 = x;
			long y1 = y;
			long z1 = z;
			x = r[i] + Math.min(y1, z1);
			y = g[i] + Math.min(x1, z1);
			z = b[i] + Math.min(x1, y1);
		}
		return Math.min(x, Math.min(y, z));
	}
}
