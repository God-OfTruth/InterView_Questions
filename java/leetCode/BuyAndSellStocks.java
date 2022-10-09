package Leet_Code;

public class BuyAndSellStocks {
    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
    public static int maxProfit(int[] prices) {
        int profit = 0;
        int buy =0, sell = 0;
        for (int i = 0; i < prices.length; i++) {
            for (int j=0; j< prices.length; j++){
                if(prices[j] - buy > profit) {
                    profit = prices[j] - buy;
                }
            }
        }
        return profit;
    }
}
