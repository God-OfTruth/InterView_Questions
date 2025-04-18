package leet_code;

import java.util.HashSet;
import java.util.Set;

public class _3396 {
	public static void main(String[] args) {
		System.out.println(minimumOperations(new int[]{1,2,3,4,2,3,3,5,7}));
	}

	public static int minimumOperations(int[] nums) {
		int start = 0;
		int count = 0;
		while(!isDistinct(nums, start)){
			start = start + 3;
			count++;
		}
		return count;
	}
	public static boolean isDistinct(int[] nums, int s){
		if(s >= nums.length){
			return true;
		}
		Set<Integer> set = new HashSet<>();
		for(int i = s; i< nums.length; i++){
			if(set.contains(nums[i])){
				return false;
			} else {
				set.add(nums[i]);
			}
		}
		return true;
	}
}
