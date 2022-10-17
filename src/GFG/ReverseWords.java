package GFG;

import java.util.Scanner;

public class ReverseWords {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = getReverse(s);
        System.out.println(str);
    }

    public static String getReverse(String str){
        String[] arr = str.split("\\.");
        StringBuilder res = new StringBuilder();
        for (String s: arr) res.insert(0, s + ".");
        return res.toString().substring(0, res.length()-1);
    }
}
