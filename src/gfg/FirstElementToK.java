package gfg;

import java.util.HashMap;
import java.util.Map;

public class FirstElementToK {
	public static void main(String[] args) {
		System.out.println(firstElementKTime(new int[]{3, 1, 2}, 3, 1));
	}

	public static int firstElementKTime(int[] a, int n, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : a) {
			if (map.containsKey(i)) map.put(i, map.get(i) + 1);
			else map.put(i, 1);
			if (map.get(i) >= k) return i;
		}
		return -1;
	}
}
