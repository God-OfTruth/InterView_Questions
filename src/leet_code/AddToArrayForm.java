package leet_code;

import java.util.LinkedList;
import java.util.List;

public class AddToArrayForm {
	public static void main(String[] args) {
		int[] num = {1, 2, 4};
		int k = 23;
		addToArrayForm(num, k).forEach(System.out::print);
	}

	public static List<Integer> addToArrayForm(int[] num, int k) {
		List<Integer> ans = new LinkedList<>();
		for (int i = num.length - 1; i >= 0; --i) {
			ans.add(0, (num[i] + k) % 10);
			k = (num[i] + k) / 10;
		}
		while (k > 0) {
			ans.add(0, k % 10);
			k /= 10;
		}
		return ans;
	}
}
