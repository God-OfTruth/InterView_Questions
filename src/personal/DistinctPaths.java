package personal;

import java.util.ArrayList;
import java.util.List;

public class DistinctPaths {
	static final int MOD = 1000000007;

	public static int countPaths(int n, int m, int k, String s, int[][] edges) {
		int D = (int) s.chars().distinct().count(); // Number of distinct letters in S
		int[] letterMask = new int[n];

		// Create adjacency list
		List<Integer>[] adj = new ArrayList[n];
		for (int i = 0; i < n; i++) {
			adj[i] = new ArrayList<>();
			letterMask[i] = 1 << (s.charAt(i) - 'a');
		}
		for (int[] edge : edges) {
			adj[edge[0] - 1].add(edge[1] - 1);
			adj[edge[1] - 1].add(edge[0] - 1);
		}

		// DP array
		long[][][] dp = new long[n][k + 1][1 << 10];

		// Initialize DP table for paths of length 1
		for (int i = 0; i < n; i++) {
			dp[i][1][letterMask[i]] = 1;
		}

		// DP transitions
		for (int length = 1; length < k; length++) {
			for (int node = 0; node < n; node++) {
				for (int mask = 0; mask < (1 << 10); mask++) {
					if (dp[node][length][mask] > 0) {
						for (int neighbor : adj[node]) {
							int newMask = mask | letterMask[neighbor];
							dp[neighbor][length + 1][newMask] =
									(dp[neighbor][length + 1][newMask] + dp[node][length][mask]) % MOD;
						}
					}
				}
			}
		}

		// Count valid paths of length K
		long result = 0;
		for (int node = 0; node < n; node++) {
			result = (result + dp[node][k][(1 << D) - 1]) % MOD;
		}

		return (int) result;
	}

	public static void main(String[] args) {
		int n = 4, m = 3, k = 2;
		String s = "aabb";
		int[][] edges = { {1, 2}, {2, 3}, {3, 4} };

		System.out.println(countPaths(n, m, k, s, edges)); // Output the number of valid paths
	}
}
