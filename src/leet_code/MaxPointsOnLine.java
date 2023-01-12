package leet_code;

import java.util.HashMap;
import java.util.Map;

public class MaxPointsOnLine {
	public static void main(String[] args) {
		int[][] points = {{1, 1}, {2, 2}, {3, 3}};
		System.out.println(maxPoints(points));
	}

	public static int maxPoints(int[][] points) {
		if (points == null || points.length == 0) return 0;
		Map<Double, Integer> map = new HashMap<>();
		int max = 1;
		int same;
		for (int i = 1; i < points.length; i++) {
			same = 0;
			int currMax = 1;
			int p1x = points[i][0];
			int p1y = points[i][1];
			for (int j = 0; j < i; j++) {
				double slope;
				int p2x = points[j][0];
				int p2y = points[j][1];
				if (p1x == p2x && p1y == p2y) {
					same++;
					currMax++;
					continue;
				} else if (p1x == p2x) {
					slope = Double.MAX_VALUE;
				} else {
					slope = (double) (p2y - p1y) / (double) (p2x - p1x);
				}
				int hits = map.getOrDefault(slope, 1) + 1;
				map.put(slope, hits);
				currMax = Math.max(currMax, hits + same);
			}
			max = Math.max(max, currMax);
			map.clear();
		}
		return max;
	}
}