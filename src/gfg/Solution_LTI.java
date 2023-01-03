package gfg;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_LTI {
    public static int smallestStockPrice(int[] stock, int valueK){
        Arrays.sort(stock);
        return stock[valueK-1];
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int stock_size = sc.nextInt();
        int[] stock = new int[stock_size];
        for (int i = 0; i < stock_size; i++) {
            stock[i] = sc.nextInt();
        }
        int valueK = sc.nextInt();
        System.out.println(smallestStockPrice(stock, valueK));
        System.out.println(flippedBits(stock_size, valueK));
    }

    public static int flippedBits(int num1, int num2){
        StringBuilder s1 = new StringBuilder(Integer.toBinaryString(num1));
        StringBuilder s2 = new StringBuilder(Integer.toBinaryString(num2));
        int answer = 0;
        if (s1.length() - s2.length() < 0) for (int i = 0; i > (s1.length() - s2.length()); i--) s1.insert(0, "0");
        else for (int i = 0; i < (s1.length() - s2.length()); i++) s2.insert(0, "0");

        for (int i = 0; i < s1.length(); i++) {
            if(s1.charAt(i) != s2.charAt(i)) answer++;
        }
        return answer;
    }
}
