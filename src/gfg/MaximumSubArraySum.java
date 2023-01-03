package gfg;

import java.util.ArrayList;

public class MaximumSubArraySum {
	public static void main(String[] args) {
		int[] arr = {8, 5, 10, 7, 9, 4, 15, 12, 90, 13};
		System.out.println(max_of_subarrays(arr, arr.length, 4));
	}
	static ArrayList<Integer> max_of_subarrays(int[] arr, int n, int k)
	{
		ArrayList<Integer> res = new ArrayList<>();
		for(int i=0; i<=n-k; i++) res.add(getMax(arr, i, k));
		return res;
	}
	static int getMax(int[] arr, int x, int k){
		int max = Integer.MIN_VALUE;
		for(int i=x; i<x+k; i++) max = Math.max(max, arr[i]);
		return max;
	}
}
