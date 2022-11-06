package GFG;

public class BaseEquivalence {
	public static void main(String[] args) {
		System.out.println(baseEquiv(8, 3));
	}

	static String baseEquiv(int n, int m) {
		int low = 2, high = 32;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			int countOfDigits = decimalToBase(n, mid);
			if (countOfDigits == m) return "Yes";
			else if (countOfDigits < m) high = mid - 1;
			else low = mid + 1;
		}
		return "No";
	}

	private static int decimalToBase(int n, int mid) {
		int c = 0;
		while (n > 0) {
			c++;
			n /= mid;
		}
		return c;
	}
}
