package GFG;


import java.util.ArrayList;

public class CommonElements {
	public static void main(String[] args) {
		int[] a = {1, 5, 10, 20, 40, 80};
		int[] b = {6, 7, 20, 80, 100, 23, 4, 5};
		int[] c = {3, 4, 15, 20, 30, 70, 80, 120};
		System.out.println(commonElements(a, b, c, a.length, b.length, c.length));
	}

	private static ArrayList<Integer> commonElements(int[] ar1, int[] ar2, int[] ar3, int n1, int n2, int n3) {
		ArrayList<Integer> list = new ArrayList<>();
		int i = 0, j = 0, k = 0;
		while (i < n1 && j < n2 && k < n3) {
			if (!list.contains(ar1[i]) && ar1[i] == ar2[j] && ar2[j] == ar3[k]) {
				list.add(ar1[i]);
				i++;
				j++;
				k++;
			} else if (ar1[i] < ar2[j]) i++;
			else if (ar2[j] < ar3[k]) j++;
			else k++;
		}
		return list;
	}
}
