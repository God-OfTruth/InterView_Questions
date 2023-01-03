package gfg;

import java.util.ArrayList;
import java.util.List;

class DisjointSet {
	final List<Integer> rank = new ArrayList<>();
	final List<Integer> parent = new ArrayList<>();
	final List<Integer> size = new ArrayList<>();

	public DisjointSet(int n) {
		for (int i = 0; i <= n; i++) {
			rank.add(0);
			parent.add(i);
			size.add(1);
		}
	}

	public int findUPar(int node) {
		if (node == parent.get(node)) {
			return node;
		}
		int ulp = findUPar(parent.get(node));
		parent.set(node, ulp);
		return parent.get(node);
	}

	public void unionByRank(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v) return;
		if (rank.get(ulp_u) < rank.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
		} else if (rank.get(ulp_v) < rank.get(ulp_u)) {
			parent.set(ulp_v, ulp_u);
		} else {
			parent.set(ulp_v, ulp_u);
			int rankU = rank.get(ulp_u);
			rank.set(ulp_u, rankU + 1);
		}
	}

	public void unionBySize(int u, int v) {
		int ulp_u = findUPar(u);
		int ulp_v = findUPar(v);
		if (ulp_u == ulp_v) return;
		if (size.get(ulp_u) < size.get(ulp_v)) {
			parent.set(ulp_u, ulp_v);
			size.set(ulp_v, size.get(ulp_v) + size.get(ulp_u));
		} else {
			parent.set(ulp_v, ulp_u);
			size.set(ulp_u, size.get(ulp_u) + size.get(ulp_v));
		}
	}
}

class Solution {
	public static void main(String[] args) {
		int n = 4, m = 5;
		int[][] operators = {{1, 1}, {0, 1}, {3, 3}, {3, 4}};
		System.out.println(numOfIslands(n, m, operators));
	}

	private static boolean isValid(int nrow, int ncol, int r, int c) {
		return nrow >= 0 && ncol >= 0 && nrow < r && ncol < c;
	}

	public static List<Integer> numOfIslands(int n, int m, int[][] operators) {
		DisjointSet ds = new DisjointSet(n * m);
		int[][] vis = new int[n][m];
		int count = 0;
		ArrayList<Integer> ans = new ArrayList<>();
		int len = operators.length;
		for (int[] operator : operators) {
			int row = operator[0];
			int col = operator[1];

			if (vis[row][col] == 1) {
				ans.add(count);
				continue;
			}

			vis[row][col] = 1;
			count++;
			int[] dr = {-1, 0, 1, 0};
			int[] dc = {0, 1, 0, -1};
			for (int j = 0; j < 4; j++) {
				int adjRow = row + dr[j];
				int adjCol = col + dc[j];


				if (isValid(adjRow, adjCol, n, m) && vis[adjRow][adjCol] == 1) {
					int nodeNo = row * m + col;
					int adjNodeNo = adjRow * m + adjCol;
					if (ds.findUPar(adjNodeNo) != ds.findUPar(nodeNo)) {
						--count;
						ds.unionBySize(nodeNo, adjNodeNo);
					}
				}
			}
			ans.add(count);

		}
		return ans;
	}
}