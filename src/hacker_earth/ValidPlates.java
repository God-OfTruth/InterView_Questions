package hacker_earth;

import java.util.Scanner;

public class ValidPlates {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.next();
        boolean res = checkPlate(str);
        if (res)
            System.out.println("valid");
        else
            System.out.println("invalid");
    }
    public static boolean checkPlate(String str){
        if (str.length() != 9) return false;
        if (str.charAt(6) != '-') return false;
        char c = str.charAt(2);
        if (c == 'A' || c =='E' || c == 'I' || c =='O' || c == 'U' || c =='Y') return false;
        if ((Integer.parseInt(str.charAt(7)+"") + Integer.parseInt(str.charAt(8)+"")) %2 != 0) return false;
        if ((Integer.parseInt(str.charAt(4)+"") + Integer.parseInt(str.charAt(5)+"")) %2 != 0) return false;
        if ((Integer.parseInt(str.charAt(3)+"") + Integer.parseInt(str.charAt(4)+"")) %2 != 0) return false;
        return (Integer.parseInt(str.charAt(0) + "") + Integer.parseInt(str.charAt(1) + "")) % 2 == 0;
    }

}
