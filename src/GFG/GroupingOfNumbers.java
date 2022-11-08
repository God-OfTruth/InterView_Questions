package GFG;

public class GroupingOfNumbers {
	public static void main(String[] args) {
		int[] arr = {1, 7, 2, 6};
		System.out.println(maxGroupSize(arr, arr.length, 8));
	}

	static int maxGroupSize(int[] arr, int N, int K) {
		int c = 0;
		int[] fre = new int[K];
		for (int i : arr) {
			i %= K;
			fre[i]++;
		}
		for (int i = 0; i < K; i++) {
			if (fre[i] == 0) continue;
			int j = K - i;
			if (i == 0 || i == j) c++;
			else {
				if (fre[j] != 0) {
					c += Math.max(fre[i], fre[j]);
					fre[j] = 0;
				} else c += fre[i];
				fre[i] = 0;
			}
		}
		return c;
	}
}