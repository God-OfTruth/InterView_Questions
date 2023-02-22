package gfg;

public class GeekIslands {
	public static void main(String[] args) {
		int[][] mat = {{1, 3, 3, 2, 4}, {4, 5, 6, 4, 4}, {2, 4, 5, 3, 1}, {6, 7, 1, 4, 5}, {6, 1, 1, 3, 4}};
		System.out.println(water_flow(mat, mat.length, mat[0].length));
	}

	static int water_flow(int[][] mat, int r, int c) {
		int ans = 0;
		boolean[][] visIndian = new boolean[r][c];
		boolean[][] visArabian = new boolean[r][c];

		for (int i = 0; i < c; i++) dfs(mat, visIndian, 0, i, r, c);
		for (int i = 0; i < r; i++) dfs(mat, visIndian, i, 0, r, c);

		for (int i = 0; i < r; i++) dfs(mat, visArabian, i, c - 1, r, c);
		for (int i = 0; i < c; i++) dfs(mat, visArabian, r - 1, i, r, c);

		for (int i = 0; i < r; i++)
			for (int j = 0; j < c; j++)
				if (visIndian[i][j] && visArabian[i][j]) ans++;
		return ans;
	}

	static void dfs(int[][] arr, boolean[][] vis, int i, int j, int r, int c) {
		if (i < 0 || i >= r || j < 0 || j >= c || vis[i][j]) return;
		vis[i][j] = true;

		if (j + 1 < c && !vis[i][j + 1] && arr[i][j + 1] >= arr[i][j]) dfs(arr, vis, i, j + 1, r, c);
		if (i + 1 < r && !vis[i + 1][j] && arr[i + 1][j] >= arr[i][j]) dfs(arr, vis, i + 1, j, r, c);
		if (j - 1 >= 0 && !vis[i][j - 1] && arr[i][j - 1] >= arr[i][j]) dfs(arr, vis, i, j - 1, r, c);
		if (i - 1 >= 0 && !vis[i - 1][j] && arr[i - 1][j] >= arr[i][j]) dfs(arr, vis, i - 1, j, r, c);
	}
}
