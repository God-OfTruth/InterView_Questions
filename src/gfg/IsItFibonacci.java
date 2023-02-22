package gfg;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class IsItFibonacci {
	public static void main(String[] args) {
		ArrayList<Long> geekNum = new ArrayList<>();
		geekNum.add(0L);
		geekNum.add(1L);
		geekNum.add(2L);
		int k = 6;
		System.out.println(solve(k, geekNum.size(), geekNum));
	}

	//	0, 1, 2, 3, 6, 11, 20
	static long solve(int n, int k, ArrayList<Long> geekNum) {
		long sum = 0L;
		for (int i = 0; i < k; i++) sum += geekNum.get(i);

		for (int i = k; i < n; i++) {
			Long x = geekNum.get(geekNum.size() - k);
			geekNum.add(sum);
			sum -= x;
			sum += geekNum.get(geekNum.size() - 1);
		}
		return geekNum.get(n - 1);
	}
}
