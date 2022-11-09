package Leet_Code;

import java.util.ArrayList;
import java.util.List;

public class StockSpanner {
	private static List<Integer> prices;
	private final List<Integer> dp;


	public StockSpanner() {
		prices = new ArrayList<>();
		dp = new ArrayList<>();
	}

	public int next(int price) {
		if (prices.isEmpty() || price < prices.get(prices.size() - 1)) {
			dp.add(1);
		} else {
			int i = prices.size() - 1;
			while (i >= 0 && prices.get(i) <= price) {
				i -= dp.get(i);
			}
			dp.add(prices.size() - i);
		}
		prices.add(price);
		return dp.get(dp.size() - 1);
	}
}
