package GFG;

import java.util.ArrayList;
import java.util.Arrays;

public class NumbersWith3Divisors {
	public static void main(String[] args) {
		ArrayList<Long> query = new ArrayList<>(Arrays.asList(6L, 10L));
		int q = query.size();
		threeDivisors(query, q).forEach(System.out::println);
	}

	static ArrayList<Integer> threeDivisors(ArrayList<Long> query, int q) {
		ArrayList<Integer> list = new ArrayList<>();
		for (long l : query) {
			int c = 0;
			for (int i = 2; ((long) i * i) <= l; i++) if (isPrime(i) && (long) i * i <= l) c++;
			list.add(c);
		}
		return list;
	}

	static boolean isPrime(int N) {
		for (int i = 2; i * i <= N; i++) if (N % i == 0) return false;
		return true;
	}
}
