package gfg;

public class MissingNumberInMatrix {
	public static void main(String[] args) {
		int[][] matrix = {{5, 5,}, {0, 5}};
		System.out.println(MissingNo(matrix));
	}

	public static long MissingNo(int[][] matrix) {
		int row = -1;
		int col = -1;
		long sum = 0;
		long msum = 0;
		long mdsltr = 0;
		long mdsrtl = 0;
		boolean flag = false;

		for (int i = 0; i < matrix.length; i++)
			for (int j = 0; j < matrix[0].length; j++)
				if (matrix[i][j] == 0) {
					row = i;
					col = j;
					break;
				}

		for (int i = 0; i < matrix.length; i++)
			if (i != row) {
				for (int j = 0; j < matrix[0].length; j++) sum += matrix[i][j];
				break;
			}

		for (int j = 0; j < matrix[0].length; j++)
			if (j != col) msum += matrix[row][j];

		long val = (sum - msum);

		if (val > Integer.MAX_VALUE) flag = true;

		for (int i = 0; i < matrix.length; i++) {
			long ms = 0;
			for (int j = 0; j < matrix[0].length; j++) {
				if (i == row && j == col) {
					ms += val;
					continue;
				}
				ms += matrix[i][j];
			}
			if (ms != sum) return -1;
		}

		for (int j = 0; j < matrix[0].length; j++) {
			long ms = 0;
			for (int i = 0; i < matrix.length; i++) {
				if (i == row && j == col) {
					ms += val;
					continue;
				}
				ms += matrix[i][j];
			}
			if (ms != sum) return -1;
		}

		for (int i = 0, j = 0; i < matrix.length && j < matrix[0].length; i++, j++) {
			if (i == row && j == col) {
				mdsltr += val;
				continue;
			}
			mdsltr += matrix[i][j];
		}

		if (mdsltr != sum) return -1;

		for (int i = 0, j = matrix[0].length - 1; i < matrix.length && j >= 0; i++, j--) {
			if (i == row && j == col) {
				mdsrtl += val;
				continue;
			}
			mdsrtl += matrix[i][j];
		}

		if (mdsrtl != sum) return -1;

		if (flag) return val;

		return val <= 0 ? -1 : val;
	}
}
