package leet_code;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy =0, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int price : prices) {
                if (price - buy > profit) {
                    profit = price - buy;
                }
            }
        }
        return profit;
    }
}
