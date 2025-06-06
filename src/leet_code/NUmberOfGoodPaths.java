package leet_code;

import java.util.*;

public class NUmberOfGoodPaths {
	public static void main(String[] args) {
		int[] vals = {1, 3, 2, 1, 3};
		int[][] edges = {{0, 1}, {0, 2}, {2, 3}, {2, 4}};
		System.out.println(numberOfGoodPaths(vals, edges));
	}

	static int numberOfGoodPaths(int[] vals, int[][] edges) {
		final int n = vals.length;
		int ans = n;
		UnionFind uf = new UnionFind(n);
		List<Integer>[] graph = new List[n];
		Map<Integer, List<Integer>> valToNodes = new TreeMap<>();

		for (int i = 0; i < n; ++i)
			graph[i] = new ArrayList<>();

		for (int[] edge : edges) {
			final int u = edge[0];
			final int v = edge[1];
			if (vals[v] <= vals[u])
				graph[u].add(v);
			if (vals[u] <= vals[v])
				graph[v].add(u);
		}

		for (int i = 0; i < vals.length; ++i) {
			valToNodes.putIfAbsent(vals[i], new ArrayList<>());
			valToNodes.get(vals[i]).add(i);
		}

		for (Map.Entry<Integer, List<Integer>> entry : valToNodes.entrySet()) {
			List<Integer> nodes = entry.getValue();
			for (final int u : nodes)
				for (final int v : graph[u])
					uf.unionByRank(u, v);
			Map<Integer, Integer> rootCount = new HashMap<>();
			for (final int u : nodes)
				rootCount.merge(uf.find(u), 1, Integer::sum);
			for (final int count : rootCount.values())
				ans += count * (count - 1) / 2;
		}
		return ans;
	}

	static class UnionFind {

		private final int[] id;
		private final int[] rank;

		public UnionFind(int n) {
			id = new int[n];
			rank = new int[n];
			for (int i = 0; i < n; ++i)
				id[i] = i;
		}

		public void unionByRank(int u, int v) {
			final int i = find(u);
			final int j = find(v);
			if (i == j)
				return;
			if (rank[i] < rank[j]) {
				id[i] = id[j];
			} else if (rank[i] > rank[j]) {
				id[j] = id[i];
			} else {
				id[i] = id[j];
				++rank[j];
			}
		}

		public int find(int u) {
			return id[u] == u ? u : (id[u] = find(id[u]));
		}
	}
}

