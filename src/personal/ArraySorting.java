package personal;

import java.util.ArrayList;
import java.util.List;

public class ArraySorting {
	public static int getMinIterations(List<Integer> arr) {
		int iterations = 0;
		boolean sorted = false;
		List<Integer> mutableArr = new ArrayList<>(arr); // Create a mutable copy of the input list

		while (!sorted) {
			boolean found = false;
			for (int i = 0; i < mutableArr.size() - 1; i++) {
				if (mutableArr.get(i) > mutableArr.get(i + 1)) {
					found = true;
					int sum = mutableArr.get(i) + mutableArr.get(i + 1);
					mutableArr.set(i, sum);
					mutableArr.remove(i + 1);
					iterations++;
					break;
				}
			}
			if (!found) {
				sorted = true;
			}
		}

		return iterations;
	}

	public static void main(String[] args) {
		List<Integer> arr = List.of(2, 4, 1, 3, 5);
		int result = getMinIterations(arr);
		System.out.println(result);
	}
}
