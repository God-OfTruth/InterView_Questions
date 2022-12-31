package GFG;

public class BalancedString {
	public static void main(String[] args) {
		int n = 28;
		System.out.println(balancedString(n));
	}

	static String balancedString(int N) {
		StringBuilder ans = new StringBuilder();
		String z = "abcdefghijklmnopqrstuvwxyz";
		int t = N / 26, n = N % 26, s, e;
		ans.append(z.repeat(Math.max(0, t)));
		if (n % 2 == 0) s = n / 2;
		else if (check(N)) s = (n + 1) / 2;
		else s = (n - 1) / 2;
		e = n - s;
		return ans + z.substring(0, s) + z.substring(26 - e);
	}

	static boolean check(int n) {
		int sum = 0;
		while (n > 0) {
			sum += n % 10;
			n = n / 10;
		}
		return sum % 2 == 0;
	}
}
