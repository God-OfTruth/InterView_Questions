package hacker_rank;
import java.util.*;

public class MonumentsBuilder {
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int nodes = scanner.nextInt();
		int g_nodes = scanner.nextInt();
		int[] from = new int[g_nodes];
		int[] to = new int[g_nodes];
		for (int i = 0; i < g_nodes; i++) {
			from[i] = scanner.nextInt();
			to[i] = scanner.nextInt();
		}
		int m = scanner.nextInt();

		List<Integer>[] adjList = new List[nodes + 1];
		for (int i = 1; i <= nodes; i++) {
			adjList[i] = new ArrayList<>();
		}
		for (int i = 0; i < g_nodes; i++) {
			adjList[from[i]].add(to[i]);
			adjList[to[i]].add(from[i]);
		}

		int[][] dp = new int[nodes + 1][m + 1];
		dfs(1, 0, -1, adjList, m, dp);

		int totalWays = 0;
		for (int j = 1; j <= m; j++) {
			totalWays = (totalWays + dp[1][j]) % MOD;
		}
		System.out.println(totalWays);
	}

	static void dfs(int u, int parentMonument, int parent, List<Integer>[] adjList, int m, int[][] dp) {
		for (int j = 1; j <= m; j++) {
			if (j == parentMonument) continue; // Ensure different monument types in adjacent cities
			dp[u][j] = 1;
		}

		for (int v : adjList[u]) {
			if (v == parent) continue;
			dfs(v, parentMonument, u, adjList, m, dp);
		}

		for (int v : adjList[u]) {
			if (v == parent) continue;
			for (int j = 1; j <= m; j++) {
				int ways = 0;
				for (int k = 1; k <= m; k++) {
					if (k == j || k == parentMonument) continue;
					ways = (ways + dp[v][k]) % MOD;
				}
				dp[u][j] = (int) ((long) dp[u][j] * ways % MOD);
			}
		}
	}
}
