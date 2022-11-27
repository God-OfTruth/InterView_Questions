package Leet_Code;

import java.util.Stack;

public class SumArrayMinimums {

	public static void main(String[] args) {
		int[] arr = {3, 1, 2, 4};
		System.out.println(sumSubarrayMins(arr));
	}
	private static class Pair{
		int val;
		int count;
		public Pair(int val, int count){
			this.val = val;
			this.count = count;
		}
	};


	public static int sumSubarrayMins(int[] arr) {
		double MOD = Math.pow(10, 9) + 7;
		if(arr == null || arr.length == 0) return 0;
		Stack<Pair> left = new Stack<>();
		int[] leftArr = new int[arr.length];
		Stack<Pair> right = new Stack<>();
		int[] rightArr = new int[arr.length];
		for(int i = 0; i < arr.length; i++){
			int count = 1;
			while(!left.isEmpty() && arr[i] < left.peek().val) count += left.pop().count;
			left.push(new Pair(arr[i], count));
			leftArr[i] = count;
		}
		for(int i = arr.length - 1; i >= 0; i--){
			int count = 1;
			while(!right.isEmpty() && arr[i] <= right.peek().val) count += right.pop().count;
			right.push(new Pair(arr[i], count));
			rightArr[i] = count;
		}
		long res = 0;
		for(int i = 0; i < arr.length; i++) res += (long) arr[i] * leftArr[i] * rightArr[i];
		return (int)(res % MOD);
	}
}
