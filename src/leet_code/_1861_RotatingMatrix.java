package leet_code;

import java.util.Arrays;
import java.util.Collections;

public class _1861_RotatingMatrix {
	public static void main(String[] args) {
		System.out.println(Arrays.deepToString(rotateTheBox(new char[][]{
				{'#', '#', '*', '.', '*', '.'},
				{'#', '#', '#', '*', '.', '.'},
				{'#', '#', '#', '.', '#', '.'}
		})));
	}

	private static char[][] rotateTheBox(char[][] box) {
		if (box.length == 0) {
			return new char[][]{};
		}
		int row = box.length; // 2
		int col = box[0].length; // 4
		char[][] res = new char[col][row]; // 4 * 2 (matrix)

		for (int r = row - 1; r >= 0; r--) {
			int point = col - 1;
			for (int c = col - 1; c >= 0; c--) {
				switch (box[r][c]) {
					case '*': // Update Point to just above stone
						point = c - 1;
						break;
					case '#':
						// Swap Places and move point to above position.
						char temp = box[r][point];
						box[r][point] = box[r][c];
						box[r][c] = temp;
						point--;
						break;
				}
			}
		}
//		System.out.println(Arrays.deepToString(box));
		int k = row - 1;
		for (char[] chars : box) {
			for (int c = 0; c < col; c++) {
				res[c][k] = chars[c];
			}
			k--;
		}
		return res;
	}
}
