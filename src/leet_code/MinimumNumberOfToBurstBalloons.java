package leet_code;

import java.util.Arrays;
import java.util.Comparator;

public class MinimumNumberOfToBurstBalloons {
	public static void main(String[] args) {
		int[][] points = {{-2147483646, -2147483645}, {2147483646, 2147483647}};
		System.out.println(findMinArrowShots(points));
	}

	public static int findMinArrowShots(int[][] points) {
		Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
		int ans = 1;
		int arrowX = points[0][1];
		for (int i = 1; i < points.length; ++i)
			if (points[i][0] > arrowX) {
				arrowX = points[i][1];
				++ans;
			}
		return ans;
	}
}
