package leet_code;

import java.util.*;

public class _73 {
	public static void main(String[] args) {
		int[][] matrix = new int[][]{{2, 3, 1}, {1, 0, 1}, {1, 1, 1}};
		setZeroesOp(matrix);
		System.out.println(Arrays.deepToString(matrix));
	}

	public static void setZeroes(int[][] matrix) {
		List<Integer> rows = new ArrayList<>();
		List<Integer> cols = new ArrayList<>();

		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (matrix[i][j] == 0) {
					cols.add(j);
					rows.add(i);
				}
			}
		}
		System.out.println(rows);
		System.out.println(cols);
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				if (rows.contains(i)) {
					matrix[i][j] = 0;
				} else if (cols.contains(j)) {
					matrix[i][j] = 0;
				}
			}
		}
	}

	public static void setZeroesOp(int[][] matrix) {
		boolean isCol = false;
		int R = matrix.length;
		int C = matrix[0].length;

		for (int i = 0; i < R; i++) {
			if (matrix[i][0] == 0) {
				isCol = true;
			}
			for (int j = 1; j < C; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}

		for (int i = 1; i < R; i++) {
			for (int j = 1; j < C; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}

		if (matrix[0][0] == 0) {
			for (int j = 0; j < C; j++) {
				matrix[0][j] = 0;
			}
		}

		if (isCol) {
			for (int i = 0; i < R; i++) {
				matrix[i][0] = 0;
			}
		}
	}

}
