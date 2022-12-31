package Leet_Code;

public class ReplaceOsWithXs {
	public static void main(String[] args) {
		char[][] mat = {{'X', 'O', 'X', 'O', 'X'}};
		int n = mat.length, m = mat[0].length;
		char[][] ans = fill(n, m, mat);
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				System.out.println(ans[i][j]);
			}
		}

	}

	static void dfs(char[][] a, int row, int col, int[][] vis, int[] delRow, int[] delCol) {
		vis[row][col] = 1;
		int n = a.length;
		int m = a[0].length;
		for (int i = 0; i < 4; i++) {
			int nRow = row + delRow[i];
			int nCol = col + delCol[i];
			if (nRow >= 0 && nCol >= 0 && nRow < n && nCol < m && vis[nRow][nCol] == 0 && a[nRow][nCol] == 'O')
				dfs(a, nRow, nCol, vis, delRow, delCol);
		}
	}

	static char[][] fill(int n, int m, char[][] a) {
		int[][] vis = new int[n][m];
		int[] delRow = {-1, 0, 1, 0};
		int[] delCol = {0, 1, 0, -1};
		for (int j = 0; j < m; j++) {
			if (a[0][j] == 'O' && vis[0][j] == 0) dfs(a, 0, j, vis, delRow, delCol);
			if (a[n - 1][j] == 'O' && vis[n - 1][j] == 0) dfs(a, n - 1, j, vis, delRow, delCol);
		}

		for (int i = 0; i < n; i++) {
			if (a[i][0] == 'O' && vis[i][0] == 0) dfs(a, i, 0, vis, delRow, delCol);
			if (a[i][m - 1] == 'O' && vis[i][m - 1] == 0) dfs(a, i, m - 1, vis, delRow, delCol);
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (vis[i][j] == 0 && a[i][j] == 'O')
					a[i][j] = 'X';
			}
		}
		return a;
	}
}
