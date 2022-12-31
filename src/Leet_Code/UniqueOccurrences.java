package Leet_Code;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class UniqueOccurrences {
	public static void main(String[] args) {
		int[] arr = {-3, 0, 1, 1, -3, 1, 1, 1, -3, 10, 0};
		System.out.println(uniqueOccurrences(arr));
	}

	public static boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : arr)
			if (map.containsKey(i)) map.put(i, map.get(i) + 1);
			else map.put(i, 1);
		Set<Integer> set = new HashSet<>();
		for (int i : map.values()) {
			if (set.contains(i)) return false;
			set.add(i);
		}
		return true;
	}
}
