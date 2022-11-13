package GFG;

public class MinNoOfJumps {
	public static void main(String[] args) {
		int[] arr = {2, 3, 1, 1, 2, 4, 2, 0, 1, 1};
		System.out.println(minJumps(arr));
	}

	static int minJumps(int[] arr) {
		int n = arr.length;
		int[] jumps = new int[n];
		int min;

		jumps[n - 1] = 0;
		for (int i = n - 2; i >= 0; i--)
			if (arr[i] == 0) jumps[i] = Integer.MAX_VALUE;
			else if (arr[i] >= n - i - 1) jumps[i] = 1;
			else {
				min = Integer.MAX_VALUE;
				for (int j = i + 1; j < n && j <= arr[i] + i; j++)
					if (min > jumps[j]) min = jumps[j];
				if (min != Integer.MAX_VALUE) jumps[i] = min + 1;
				else jumps[i] = min;
			}
		return jumps[0];
	}
}
