package GFG;

import java.util.ArrayList;
import java.util.Objects;

public class ReplaceLeastGreater {
	public static void main(String[] args) {
		int[] arr = new int[]{8, 58, 71, 18, 31, 32, 63, 92, 43, 3, 91, 93, 25, 80, 28};
		System.out.println(Objects.requireNonNull(findLeastGreater(arr.length, arr)).toString());
	}

	public static ArrayList<Integer> findLeastGreater(int n, int[] arr) {
		ArrayList<Integer> list = new ArrayList<>();
		for (int i = 0; i < n; i++) list.add(leastGreater(arr, arr[i], i + 1));
		return list;
	}

	static int leastGreater(int[] arr, int s, int start) {
		int min = Integer.MAX_VALUE;
		for (int i = start; i < arr.length; i++) if (arr[i] > s) if (arr[i] < min) min = arr[i];
		if (min == Integer.MAX_VALUE) return -1;
		return min;
	}
}

// 18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, -1, 28, -1, -1
// 18, 63, 80, 25, 32, 43, 80, 93, 80, 25, 93, 2147483647, 28, 2147483647
