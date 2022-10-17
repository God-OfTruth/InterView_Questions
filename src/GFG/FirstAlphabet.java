package GFG;

import java.util.Scanner;

public class FirstAlphabet {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        System.out.println(getFirstAlphabet(str));
    }
    public static String getFirstAlphabet(String str){
        StringBuilder res = new StringBuilder();
        String[] arr = str.split(" ");
        for (String s : arr){
            res.append(s.charAt(0));
        }
        return res.toString();
    }
}
