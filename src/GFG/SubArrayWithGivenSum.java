package GFG;

import java.util.ArrayList;
import java.util.List;

public class SubArrayWithGivenSum {
	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 7, 5};
		System.out.println(subArraySum(arr, arr.length, 12));
	}

	public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
		int currentsum = arr[0], begin = 0, i;
		for (i = 1; i <= n; i++) {
			while (currentsum > s && begin < i - 1) {
				currentsum = currentsum - arr[begin];
				begin++;
			}
			if (currentsum == s) {
				int p = i - 1;
				return new ArrayList<>(List.of(begin+1, p+1));
			}
			if (i < n)
				currentsum = currentsum + arr[i];
		}
		return new ArrayList<>(List.of(-1));
	}
}
