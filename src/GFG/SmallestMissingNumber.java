package GFG;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class SmallestMissingNumber {
	public static void main(String[] args) {
		int[] arr = {0, 1};
		System.out.println(missingNumber(arr, arr.length));
	}

	static int missingNumber(int[] arr, int size) {
		Set<Integer> set = new HashSet<>();
		for (int i : arr) set.add(i);
		int i = 1;
		while (i < size) if (!set.contains(i++)) return i - 1;
		return i;
	}
}
