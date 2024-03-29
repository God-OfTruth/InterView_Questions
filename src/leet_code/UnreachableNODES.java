package leet_code;

import java.util.ArrayList;
import java.util.List;

public class UnreachableNODES {
	public static void main(String[] args) {
		int[][] edges = {{0, 2}, {0, 5}, {2, 4}, {1, 6}, {5, 4}};
		System.out.println(countPairs(7, edges));
	}

	public static long countPairs(int n, int[][] edges) {
		long ans = 0;
		List[] graph = new List[n];
		boolean[] seen = new boolean[n];
		int unreached = n;

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int[] edge : edges) {
			final int u = edge[0];
			final int v = edge[1];
			graph[u].add(v);
			graph[v].add(u);
		}

		for (int i = 0; i < n; ++i) {
			final int reached = dfs(graph, i, seen);
			unreached -= reached;
			ans += (long) unreached * reached;
		}
		return ans;
	}

	private static int dfs(List<Integer>[] graph, int u, boolean[] seen) {
		if (seen[u])
			return 0;

		seen[u] = true;
		int ans = 1;
		for (final int v : graph[u])
			ans += dfs(graph, v, seen);
		return ans;
	}
}
