package codechef;

import java.util.Scanner;

public class PracticeMakesPerfect {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int count = 0;
        for (int i = 0; i < 4; i++){
            int c = sc.nextInt();
            if (c >= 10) count++;
        }
        sc.close();
        System.out.println(count);
    }
}
