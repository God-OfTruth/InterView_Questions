package GFG;

public class RowWithMaxOne1 {

	public static void main(String[] args) {
		int[][] arr = {{0, 1, 1, 1}, {0, 0, 1, 1}, {1, 1, 1, 1}, {0, 0, 0, 0}};
		System.out.println(rowWithMax1s(arr, arr.length, arr[0].length));
	}

	static int rowWithMax1s(int[][] arr, int n, int m) {
		int R = n;
		int C = m;
		int j, max_row_index = 0;
		j = C - 1;
		for (int i = 0; i < R; i++)
			while (j >= 0 && arr[i][j] == 1) {
				j = j - 1;
				max_row_index = i;
			}
		if (max_row_index == 0 && arr[0][C - 1] == 0) return -1;
		return max_row_index;
	}
}
