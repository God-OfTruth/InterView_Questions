package gfg;

public class RowWithMaxOne1 {

	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
		System.out.println(rowWithMax1s(arr, arr.length, arr[0].length));
	}

	static int rowWithMax1s(int[][] arr, int n, int m) {
		int j, max_row_index = 0;
		j = m - 1;
		for (int i = 0; i < n; i++)
			while (j >= 0 && arr[i][j] == 1) {
				j = j - 1;
				max_row_index = i;
			}
		if (max_row_index == 0 && arr[0][m - 1] == 0) return -1;
		return max_row_index;
	}
}
