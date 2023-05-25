package personal;

import java.text.DecimalFormat;

public class LogitRegression {
	public static void main(String[] args) {
//		System.out.println(trappingWater(new int[]{0, 2, 4, 0, 2, 1, 2, 6}));
		System.out.println(logitRegression(new int[]{2, 0, 5, 5}));
	}

	static String logitRegression(int[] arr) {
		int x = arr[0];
		int y = arr[1];
		int a = arr[2];
		int b = arr[3];
		double ans = (1.0 / (1.0 + Math.exp(-a * x - b)));
		double ans1 = (1.0 / (1.0 + Math.exp(-a * y - b)));
		DecimalFormat decimalFormat = new DecimalFormat("0.###");

		return "" + decimalFormat.format(ans) + ", " + decimalFormat.format(ans1);
	}

	static int trappingWater(int[] arr) {
		int left = 0;
		int right = arr.length - 1;
		int l_max = 0;
		int r_max = 0;
		int result = 0;
		while (left <= right) {
			if (r_max <= l_max) {
				result += Math.max(0, r_max - arr[right]);
				r_max = Math.max(r_max, arr[right]);
				right -= 1;
			} else {
				result += Math.max(0, l_max - arr[left]);
				l_max = Math.max(l_max, arr[left]);
				left += 1;
			}
		}
		return result;
	}
}
