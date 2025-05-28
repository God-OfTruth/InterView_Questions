package leet_code;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class _2176 {
	public static void main(String[] args) {
		System.out.println(countPairs(new int[]{3,1,2,2,2,1,3}, 2));
	}

	public static int countPairs(int[] nums, int k) {
		Map<Integer, List<Integer>> map = new HashMap<>();
		int ans = 0;
		for (int i = 0; i < nums.length; i++) {
			List<Integer> array = map.getOrDefault(nums[i], List.of(i));
			array.add(8);
			map.put(nums[i], array);
		}
		for (int i = 0; i < nums.length; i++) {
			List<Integer> indexes = map.get(nums[i]);
			indexes.forEach(index->{
//				if(index != i && )
			});
		}
		return ans;
	}
}
