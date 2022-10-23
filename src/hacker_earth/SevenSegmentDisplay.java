package hacker_earth;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SevenSegmentDisplay {
    public static int countMatches(int n) {
        if (n == 0) return 6;
        int count = 0;
        List<Integer> arr = new ArrayList<>();
        arr.add(6);
        arr.add(2);
        arr.add(5);
        arr.add(5);
        arr.add(4);
        arr.add(5);
        arr.add(6);
        arr.add(3);
        arr.add(7);
        arr.add(6);
        while (n > 0) {
            int c = n % 10;
            n = n / 10;
            count += arr.get(c);
            if (n == 0) count += 6;
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            t--;
            int n = sc.nextInt();
            System.out.println(countMatches(n));
        }
    }
}


class Test {

    public class SevenSegmentDisplay {
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            int testCase = sc.nextInt();
            sc.nextLine();
            for (int i = 0; i < testCase; i++) {
                String num = sc.nextLine();
                long totStick = 0;
                for (int k = 0; k < num.length(); k++) {
                    totStick = totStick + countReturn(num.charAt(k));
                }
                StringBuilder MaxNum = new StringBuilder();
                if (totStick % 2 == 1) {
                    MaxNum.append("7");
                    totStick = totStick - 3;
                }
                for (int j = 0; j < (totStick / 2); j++) {
                    MaxNum.append("1");
                }
                System.out.println(MaxNum);
            }
        }

        public static long countReturn(char a) {        // { 0, 1, 2, 3, 4, 5, 6, 7, 8, 9}        // { 6, 2, 5, 5, 4, 5, 6, 3, 7, 6}        // System.out.println(a);        switch (a){            case '1':                return 2;            case '7':                return 3;            case '9':            case '0':            case '6':                return 6;            case '2':            case '3':            case '5':                return 5;            case '8':                return 7;            default:                return 4;        }    }}
            return 0l;
        }
    }
}