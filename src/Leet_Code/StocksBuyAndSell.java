package Leet_Code;

import java.util.ArrayList;
import java.util.Arrays;

public class StocksBuyAndSell {
	public static void main(String[] args) {
		int[] stockPrice = {4, 2, 2, 2, 4};
		System.out.println(stockBuySell(stockPrice, stockPrice.length));
	}

	static ArrayList<ArrayList<Integer>> stockBuySell(int[] A, int n) {
		ArrayList<ArrayList<Integer>> profit = new ArrayList<>();
		for (int i = 0; i < n - 1; i++) {
			int j = i + 1;
			if (A[i] >= A[j]) {
				j++;
				continue;
			}
			int p = A[j];
			while (j < n - 1 && A[j + 1] > p) p = A[++j];
			ArrayList<Integer> a = new ArrayList<>();
			a.add(i);
			a.add(j);
			profit.add(a);
			i = j - 1;
		}
		return profit;
	}
}
