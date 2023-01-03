package leet_code;

public class RectangleArea {
	public static void main(String[] args) {
		System.out.println(computeArea(-3, 0, 3, 4, 0, -1, 9, 2));
	}

	public static int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
		int a = Math.max(ax1, bx1);
		int b = Math.min(ax2, bx2);
		int c = Math.max(ay1, by1);
		int d = Math.min(ay2, by2);

		int overlap = 0;

		if (a < b && c < d) overlap = (b - a) * (d - c);
		return (ax2 - ax1) * (ay2 - ay1) + (bx2 - bx1) * (by2 - by1) - overlap;
	}
}
