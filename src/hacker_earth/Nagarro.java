package hacker_earth;

import java.util.Scanner;

public class Nagarro {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String str = getReverse(s);
        System.out.println(str);
    }

    public static String reverse(String str){
        StringBuilder s = new StringBuilder();
        for (int i=0; i<str.length(); i++){
            s.insert(0, str.charAt(i));
        }
        String r = s.toString();
        r = r.substring(0,1).toUpperCase() + r.substring(1);
        return r;
    }
    public static String getReverse(String str){
        str = str.toLowerCase();
        String[] arr = str.split(" ");
        StringBuilder res = new StringBuilder();
        for (String s: arr){
            String r = reverse(s);
            res.append(" ").append(r);
        }
        return res.substring(1);
    }
}
