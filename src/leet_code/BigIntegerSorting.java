package leet_code;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class BigIntegerSorting {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		List<String> s = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			s.add(sc.next());
		}
		sc.close();
		bigSort(s);
		for (String str : s)
			System.out.print(str + " ");
	}

	public static void bigSort(List<String> str) {
		str.sort((a, b) -> {
			if (a.length() > b.length()) return 1;
			else if (a.length() < b.length()) return -1;
			else {
				BigInteger b1 = new BigInteger(a);
				BigInteger b2 = new BigInteger(b);
				return b1.compareTo(b2);

			}
		});
	}

}
