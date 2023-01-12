package gfg;

import java.util.PriorityQueue;
import java.util.Queue;

public class MinimizeTheSum {
	public static void main(String[] args) {
		int[] arr = {1, 3, 7, 5, 6};
		System.out.println(minimizeSum(args.length, arr));
	}

	static long minimizeSum(int n, int[] arr) {
		long ans = 0;
		Queue<Integer> queue = new PriorityQueue<>();
		for (int i : arr) queue.add(i);
		while (queue.size() > 1) {
			int curr = queue.remove() + queue.remove();
			ans+= curr;
			queue.add(curr);
		}
		return ans;
	}
}
