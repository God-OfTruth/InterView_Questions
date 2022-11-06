package Leet_Code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ToePlitz {
	public static void main(String[] args) {
		int[][] a = {{65}, {98},{57}};
		System.out.println(isToeplitzMatrix(a));
//		System.out.println(diagonal(a));
//		diagonal(a);
	}

	public static boolean isToeplitzMatrix(int[][] matrix) {
		if (matrix.length == 0 || matrix[0].length == 0) return false;
		if (matrix.length == 1 || matrix[0].length == 1) return true;
		int n = matrix.length - 1;
		for (int g = n; g >= 0; g--) {
			Set<Integer> set = new HashSet<>();
			for (int i = g, j = 0; j <= n - g; j++, i++) {
				set.add(matrix[i][j]);
			}
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

	public static void diagonal(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
//		for (int i=0; i<matrix.length; i++){
//			arr.add(matrix[i][i]);
//		}
		int n = matrix.length - 1;
		for (int g = n; g >= 0; g--) {
			for (int i = g, j = 0; j <= n - g; j++, i++) {
				list.add(matrix[i][j]);
			}
		}
		for (int g = 1; g < matrix[0].length; g++) {
			for (int i = 0, j = g; j < matrix[0].length; j++, i++)
				list.add(matrix[i][j]);
		}
		System.out.println(list);
//		return arr;
	}
//	public static boolean isToeplitzMatrix(int[][] a) {
//		int row = 0;
//		int col;
//		while (row < a.length) {
//			col = 0;
//			int rowTemp = row;
//			Set<Integer> arr = new HashSet<>();
//			while (rowTemp >= 0) {
//				System.out.print(a[rowTemp][col] + " ");
//				arr.add(a[rowTemp][col]);
//				rowTemp--;
//				col++;
//			}
//			System.out.println();
//			if (arr.size() != 1) return false;
//			row++;
//		}
//
//		//print second half
//		col = 1;
//
//		while (col < a.length) {
//			int colTemp = col;
//			row = a.length - 1;
//			Set<Integer> arr = new HashSet<>();
//			while (colTemp <= a.length - 1) {
//				System.out.print(a[row][colTemp] + " ");
//				arr.add(a[row][colTemp]);
//				row--;
//				colTemp++;
//			}
//			System.out.println();
//			if (arr.size() != 1) return false;
//			col++;
//		}
//		return true;
//	}
}
