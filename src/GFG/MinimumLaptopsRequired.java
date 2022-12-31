package GFG;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class MinimumLaptopsRequired {
	public static void main(String[] args) {
		int N = 3;
		int[] start = {1, 5, 2};
		int[] end = {2, 6, 3};
		System.out.println(minLaptops(N, start, end));
	}

	public static int minLaptops(int n, int[] start, int[] end) {
		int[][] arr = new int[n][2];
		for (int i = 0; i < n; i++) arr[i] = new int[]{start[i], end[i]};
		Arrays.sort(arr, MinimumLaptopsRequired::compare);
		int ans = 1;
		Queue<Integer> queue = new PriorityQueue<>();
		queue.add(arr[0][1]);
		int i = 1;
		while (i < n) {
			int s = arr[i][0];
			int e = arr[i][1];
			if (!queue.isEmpty() && queue.peek() <= s) {
				queue.remove();
			} else {
				ans++;
			}
			queue.add(e);
			i++;
		}
		return ans;
	}

	private static int compare(int[] a, int[] b) {
		if (a[0] != b[0]) return a[0] - b[0];
		return a[1] - b[1];
	}
}
