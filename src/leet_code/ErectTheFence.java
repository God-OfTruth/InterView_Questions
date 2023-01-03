package leet_code;

import java.util.*;

public class ErectTheFence {
	public static void main(String[] args) {
		int[][] trees = {{1, 1}, {2, 2}, {2, 0}, {2, 4}, {3, 3}, {4, 2}};
		System.out.println(Arrays.deepToString(outerTrees(trees)));
	}

	public static int[][] outerTrees(int[][] trees) {
		List<Point> points = new ArrayList<>();
		for (int[] point : trees) points.add(new Point(point[0], point[1]));
		List<Point> res = new ArrayList<>();
		if (points.size() == 1) return trees;
		int n = points.size();
		points.sort((o1, o2) -> o1.y == o2.y ? o1.x - o2.x : o1.y - o2.y);
		HashSet<ArrayList<Integer>> dup = new HashSet<>();
		Stack<Point> hull = new Stack<>();
		hull.push(points.get(0));
		hull.push(points.get(1));
		for (int i = 2; i < n; i++) {
			Point top = hull.pop();
			while (!hull.isEmpty() && ccw(hull.peek(), top, points.get(i)) < 0) top = hull.pop();
			hull.push(top);
			hull.push(points.get(i));
		}

		for (int i = n - 2; i >= 0; i--) {
			Point top = hull.pop();
			while (!hull.isEmpty() && ccw(hull.peek(), top, points.get(i)) < 0) top = hull.pop();
			hull.push(top);
			hull.push(points.get(i));
		}

		for (Point x : hull) {
			ArrayList<Integer> tmp = new ArrayList<>();
			tmp.add(x.x);
			tmp.add(x.y);
			if (dup.contains(tmp)) continue;
			dup.add(tmp);
			res.add(x);
		}
		int[][] ans = new int[res.size()][2];
		int i = 0;
		for (Point p : res) {
			ans[i][0] = p.x;
			ans[i][1] = p.y;
			i++;
		}
		return ans;
	}

	private static int ccw(Point a, Point b, Point c) {
		double crossProduct = (b.x - a.x) * (c.y - a.y) - (b.y - a.y) * (c.x - a.x);
		if (crossProduct < 0) return -1;
		if (crossProduct > 0) return 1;
		return 0;
	}
}

class Point {
	final int x;
	final int y;

	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}