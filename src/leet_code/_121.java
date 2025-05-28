package leet_code;

public class _121 {
	public static void main(String[] args) {
		System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
	}

//	/**
//	 * @param prices array of prices.
//	 * @return maxProfit we can attain
//	 * @apiNote Works in O(n^2) time and O(1) space
//	 */
//	public static int maxProfit(int[] prices) {
//		int max = 0;
//		for (int i = 0; i < prices.length; i++) {
//			for (int j = i + 1; j < prices.length; j++) {
//				if (prices[j] > prices[i]) {
//					max = Math.max(max, prices[j] - prices[i]);
//				}
//			}
//		}
//		return max;
//	}

	/**
	 * @param prices array of prices.
	 * @return maxProfit we can attain
	 * @apiNote Works in O(n) time and O(1) space
	 */
	public static int maxProfit(int[] prices) {
		int maxProfit = 0;
		int min = Integer.MAX_VALUE;

		for (int price : prices) {
			min = Math.min(min, price);
			maxProfit = Math.max(maxProfit, price - min);
		}

		return maxProfit;
	}
}
