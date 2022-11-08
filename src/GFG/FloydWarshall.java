package GFG;

import java.util.Arrays;

public class FloydWarshall {
	public static void main(String[] args) {
		int[][] matrix =
				{
						{0, 4, 2, 1, 2, 9, 4, 8, -1, 4, -1, -1},
						{9, 0, 3, 6, 2, 6, 2, 3, 6, -1, -1, 3},
						{7, 1, 0, 10, 8, 9, 1, 3, -1, 7, -1, 10},
						{5, 1, 9, 0, 3, -1, 1, 10, 7, 1, -1, 7},
						{-1, 5, 1, 4, 0, 2, 10, 4, 10, 6, 4, 5},
						{7, 8, 3, 7, 5, 0, 5, 1, 3, 5, 7, 2},
						{6, -1, 6, 1, 10, 7, 0, 10, -1, -1, 7, 7}
				};
		shortest_distance(matrix);
	}

	public static void shortest_distance(int[][] matrix) {
		int n = matrix.length;
		for (int k = 0; k < n; k++)
			for (int i = 0; i < n; i++)
				for (int j = 0; j < n; j++) {
					if (matrix[i][k] == -1 || matrix[k][j] == -1) continue;
					if (matrix[i][j] == -1 || matrix[i][k] + matrix[k][j] < matrix[i][j])
						matrix[i][j] = matrix[i][k] + matrix[k][j];
				}

		for (int[] ar : matrix)
			System.out.println(Arrays.toString(ar));
	}
}
