package GFG;

import java.util.Scanner;
import java.util.Stack;

public class BracketBalance {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(checkString(s));
        sc.close();
    }
    public static boolean checkString(String s){
        if (s.length()  == 0) return false;
        char[] arr = s.toCharArray();
        Stack<Character> balance = new Stack<>();
        balance.push(arr[0]);
        for (int i = 1; i<arr.length; i++){
            switch (balance.peek()) {
                case '{' -> {
                    System.out.println(balance.peek() + " - " + arr[i]);
                    if (arr[i] == '}') balance.pop();
                    else balance.push(arr[i]);
                }
                case '(' -> {
                    System.out.println(balance.peek() + " - " + arr[i]);
                    if (arr[i] == ')') balance.pop();
                    else balance.push(arr[i]);
                }
                case '[' -> {
                    System.out.println(balance.peek() + " - " + arr[i]);
                    if (arr[i] == ']') balance.pop();
                    else balance.push(arr[i]);
                }
                default -> {
                    System.out.println(balance.peek() + " - " + arr[i]);
                    balance.push(arr[i]);
                }
            }
        }
        return balance.isEmpty();
    }
}
