import java.util.Arrays;

public class ques {
	public static void main(String[] args) {
		int[] n = {11, 7, 5, 10, 46, 23, 8, 16};
		int x = 3;
		System.out.println(Arrays.toString(n));
		convert(n, x);
		System.out.println(Arrays.toString(n));
	}

	static void convert(int[] arr, int x) {
		sort(arr, 0, x -1, true);
		sort(arr, x+1, arr.length - 1, false);
	}

	static void merge(int[] arr, int l, int m, int r) {
		int n1 = m - l + 1;
		int n2 = r - m;

		int[] L = new int[n1];
		int[] R = new int[n2];

		System.arraycopy(arr, l, L, 0, n1);
		for (int j = 0; j < n2; ++j)
			R[j] = arr[m + 1 + j];
		int i = 0, j = 0;
		int k = l;
		while (i < n1 && j < n2) {
			if (L[i] <= R[j]) {
				arr[k] = L[i];
				i++;
			} else {
				arr[k] = R[j];
				j++;
			}
			k++;
		}
		while (i < n1) {
			arr[k] = L[i];
			i++;
			k++;
		}
		while (j < n2) {
			arr[k] = R[j];
			j++;
			k++;
		}
	}

	static void sort(int[] arr, int l, int r, boolean asc) {
		if(asc){
			if (l < r) {
				int m = l + (r - l) / 2;
				sort(arr, l, m, true);
				sort(arr, m + 1, r, true);
				merge(arr, l, m, r);
			}
		} else {
			if (l > r) {
				int m = l + (r - l) / 2;
				sort(arr, l, m, false);
				sort(arr, m + 1, r, false);
				merge(arr, l, m, r);
			}
		}
	}
}
