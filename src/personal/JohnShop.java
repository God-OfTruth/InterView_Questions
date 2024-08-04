package personal;

import java.sql.Array;
import java.util.*;

public class JohnShop {
	public static void main(String[] args) {
		System.out.println(calculateSums(List.of(8, 3, -2, 1, -5), List.of(List.of(1, 3), List.of(2, 5), List.of(5, 5))));
	}

	public static List<Long> calculateSums(List<Integer> arr, List<List<Integer>> queries) {
		int n = arr.size();
		Long[] pref = new Long[n + 1];
		for (int i = 0; i <= n; i++) {
			pref[i] = 0L;
		}
		for (int i = 0; i < n; i++) {
			pref[i + 1]= pref[(i)] + arr.get(i);
		}

		List<Long> ans = new ArrayList<>();
		int q = queries.size();

		for (List<Integer> query : queries) {
			int s = query.get(0);
			int e = query.get(1);
			ans.add(pref[(e)] - pref[(s - 1)]);
		}
		return ans;
	}
}
