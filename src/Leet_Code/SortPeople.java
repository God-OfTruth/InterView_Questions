package Leet_Code;

import java.util.Arrays;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortPeople {
	public static void main(String[] args) {
		String[] names = {"Mary","John","Emma"};
		int[] heights = {180,165,160};
		System.out.println(Arrays.toString(sortPeople(names, heights)));
	}
	public static String[] sortPeople(String[] names, int[] heights) {
		SortedMap<Integer, String> map = new TreeMap<>();
		String[] res = new String[names.length];
		for(int i=0; i<names.length; i++) map.put(heights[i], names[i]);
		int i=0;
		int x = map.firstKey();
		while (!map.isEmpty()){
			res[i] = map.get(x);
			System.out.println(map.get(x));
			map.remove(x);
		}
		return res;
	}
}
