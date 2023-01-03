package gfg;

import java.util.ArrayList;
import java.util.List;

public class MinimizeNumberOfStudentsToBeRemoved {
	public static void main(String[] args) {
		int[] height = {9, 1, 2, 3, 1, 5};
		System.out.println(removeStudents(height, height.length));
	}

	public static int removeStudents(int[] height, int n) {
		List<Integer> arr = new ArrayList<>();
		arr.add(0, height[0]);
		int j = 0;
		for (int i = 1; i < n; i++)
			if (height[i] > arr.get(j)) {
				++j;
				arr.add(j, height[i]);
			} else {
				int index = lowerBound(arr, height[i]);
				arr.set(index, height[i]);
			}
		return n - arr.size();
	}

	public static int lowerBound(List<Integer> arr, int key) {
		int low = 0, high = arr.size();
		int mid;
		while (low < high) {
			mid = low + (high - low) / 2;
			if (key <= arr.get(mid)) high = mid;
			else low = mid + 1;
		}
		if (low < arr.size() && arr.get(low) < key) low++;
		return low;
	}
}
