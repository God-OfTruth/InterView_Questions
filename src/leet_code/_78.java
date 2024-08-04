package leet_code;

import java.util.ArrayList;
import java.util.List;

public class _78 {
	public static void main(String[] args) {
		System.out.println(subsets(new int[]{1, 2, 3}));
	}

	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		res.add(new ArrayList<>());
		for (int num : nums) {
			int n = res.size();
			for (int i = 0; i < n; i++) {
				List<Integer> temp = new ArrayList<>(res.get(i));
				temp.add(num);
				res.add(temp);
			}
		}
		return res;
	}
}
