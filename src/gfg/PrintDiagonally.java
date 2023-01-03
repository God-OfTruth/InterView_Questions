package gfg;

import java.util.ArrayList;

public class PrintDiagonally {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
		var x = downwardDiagonal(3, matrix);
		System.out.println(x);
	}

	static ArrayList<Integer> downwardDiagonal(int N, int[][] A) {
		ArrayList<Integer> arr = new ArrayList<>();
		for (int k = 0; k < N; k++) {
			int row = 0, col = k;
			while (col >= 0) {
				arr.add(A[row][col]);
				row++;
				col--;
			}
		}
		for (int j = 1; j < N; j++) {
			int col = N - 1, row = j;
			while (row < N) {
				arr.add(A[row][col]);
				row++;
				col--;
			}
		}
		return arr;
	}
}
