package gfg;

public class TheSmurfs {
	public static void main(String[] args) {
		String[] arr = {"R", "G", "B", "R", "B"};
		System.out.println(minFind(arr.length, arr));
	}

	static int minFind(int n, String[] a) {
		int r = 0, g = 0, b = 0;
		for (String s : a) {
			if (s.equals("R")) r++;
			if (s.equals("B")) b++;
			if (s.equals("G")) g++;
		}

		if (r == n || g == n || b == n) return n;
		if ((r % 2 == 0 && g % 2 == 0 && b % 2 == 0) || (r % 2 == 1 && g % 2 == 1 && b % 2 == 1)) return 2;
		return 1;
	}
}
/*
 *  R G B
 *
 * R G
 * R B
 * G B
 *
 * */