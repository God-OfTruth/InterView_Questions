package gfg;

import java.util.ArrayList;

public class MaximumSumArray {
	public static void main(String[] args) {
		int[] arr = {1, 2, 5, -7, 2, 3};
		System.out.println(findSubArray(arr, arr.length));
	}

	static ArrayList<Integer> findSubArray(int[] a, int n) {
		int max = 0, start = 0, end = -1, i = 0, j = 0, sum = 0;
		while (j < n) if (a[j] >= 0) {
			sum += a[j];
			j++;
		} else {
			if (sum > max) {
				max = sum;
				start = i;
				end = j - 1;
			}
			sum = 0;
			j++;
			i = j;
		}
		if (sum > max) {
			start = i;
			end = j - 1;
		}
		ArrayList<Integer> list = new ArrayList<>();
		for (int k = start; k <= end; k++) list.add(a[k]);
		if (list.size() == 0) list.add(-1);
		return list;
	}
}
