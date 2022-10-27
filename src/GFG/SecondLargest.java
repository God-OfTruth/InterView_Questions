package GFG;

public class SecondLargest {
	public static void main(String[] args) {
		int[] arr = {1, 10, 5, 10};
		System.out.println(print2largest(arr, arr.length));
	}

	static int print2largest(int[] arr, int n) {
		int m = arr[0], sm = Integer.MIN_VALUE;
		for (int i : arr)
			if (i > m) {
				sm = m;
				m = i;
			} else if (i != m && i > sm) sm = i;
		if(sm == Integer.MIN_VALUE) return -1;
		return sm;
	}
}
