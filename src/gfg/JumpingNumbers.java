package gfg;

import java.util.LinkedList;
import java.util.Queue;

public class JumpingNumbers {
	public static void main(String[] args) {
		long x = 506857579;
		System.out.println(jumpingNums(x));
	}

	static long jumpingNums(long x) {
		Queue<Long> longs = new LinkedList<>();
		for (long i = 1; i < 10; i++) longs.add(i);
		long ans = 0;
		while (!longs.isEmpty()) {
			long num = longs.remove();
			if (num > x) continue;
			ans = Math.max(ans, num);
			int lastDigit = (int) num % 10;
			if (lastDigit != 0) {
				long first = num * 10 + (lastDigit - 1);
				longs.add(first);
			}
			if (lastDigit != 9) {
				long second = num * 10 + (lastDigit + 1);
				longs.add(second);
			}
		}
		return ans;
	}

	static boolean checkIsValid(long n) {
		char[] arr = String.valueOf(n).toCharArray();
		char x = 0;
		for (int i = 1; i < arr.length; i++) {
			if (Math.abs(arr[x++] - arr[i]) != 1) return false;
		}
		return true;
	}
}
