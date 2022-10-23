package Leet_Code;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class FindErrorNumbers {
	public static void main(String[] args) {
		System.out.println(Arrays.toString(findErrorNums(new int[]{1, 4, 2, 2})));
	}
	public static int[] findErrorNums(int[] nums) {
		Set<Integer> arr = new HashSet<>();
		int[] res = new int[2];
		for(int i: nums){
			if(arr.contains(i)){
				res[0] = i;
			}
			else arr.add(i);
		}
		for(int i=0; i<nums.length; i++)
			if(!arr.contains(i)) res[1] = i;
		return res;
	}
}
