package leet_code;

public class ReverseInteger {
	public static void main(String[] args) {
		System.out.println(reverse(-2343));
	}

	public static int reverse(int x) {
		int result = 0;
		while (x != 0) {
			int tail = x % 10;
			int newResult = result * 10 + tail;
			if (((newResult - tail) / 10) != result) return 0;
			result = newResult;
			x = x / 10;
		}
		return result;
	}
}
