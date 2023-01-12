package gfg;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ShortestPrimePath {
	public static void main(String[] args) {
		Solutions solution = new Solutions();
		int n1 = 1033;
		int n2 = 8179;
		System.out.println(solution.shortestPath(n1, n2));
	}
}

class Solutions {
	int[] prime;

	Solutions() {
		prime = new int[10000];
		Arrays.fill(prime, 1);
		prime[1] = 0;
		for (int i = 2; i < 10000; i++)
			if (prime[i] == 1)
				for (int j = i * i; j < 10000; j += i) prime[j] = 0;
	}

	public int shortestPath(int n1, int n2) {
		int[] ans = new int[10000];
		Arrays.fill(ans, -1);
		boolean[] vis = new boolean[10000];
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n1);
		vis[n1] = false;
		ans[n1] = 0;
		while (!queue.isEmpty()) {
			int curr = queue.poll();
			if (vis[curr]) continue;
			String x = Integer.toString(curr);
			for (int i = 0; i < 4; i++)
				for (char ch = '0'; ch <= '9'; ch++) {
					if (ch == x.charAt(i) || (ch == '0' & i == 0)) continue;
					String y = x.substring(0, i) + ch + x.substring(i + 1);
					int z = Integer.parseInt(y);
					if (prime[z] == 1 && ans[z] == -1) {
						ans[z] = 1 + ans[curr];
						queue.add(z);
					}
				}
		}
		return ans[n2];
	}
}