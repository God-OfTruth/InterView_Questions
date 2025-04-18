package leet_code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class _1 {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
	}

	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for(int i=0; i<nums.length; i++){
			int rem = target - nums[i];
			if(map.containsKey(rem)){
				return new int[]{map.get(rem), i};
			} else {
				map.put(nums[i], i);
			}
		}
		return new int[]{0, 0};
	}
}
