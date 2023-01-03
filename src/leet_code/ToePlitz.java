package leet_code;

import java.util.HashSet;
import java.util.Set;

public class ToePlitz {
	public static void main(String[] args) {
		int[][] a = {{65}, {98}, {57}};
		System.out.println(isToeplitzMatrix(a));
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		if (matrix.length == 1 || matrix[0].length == 1) return true;
		int n = matrix.length - 1;
		for (int g = n; g >= 0; g--) {
			Set<Integer> set = new HashSet<>();
			for (int i = g, j = 0; j <= n - g; j++, i++) set.add(matrix[i][j]);
			if (set.size() > 1) return false;
		}
		for (int g = 1; g < matrix[0].length; g++) {
			Set<Integer> set = new HashSet<>();
			for (int i = 0, j = g; j < matrix[0].length; j++, i++)
				set.add(matrix[i][j]);
			if (set.size() > 1) return false;
		}
		return true;
	}
}
