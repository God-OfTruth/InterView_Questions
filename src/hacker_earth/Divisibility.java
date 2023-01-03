package hacker_earth;

import java.util.Scanner;

class Divisibility {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int num = 0;
        for(int i: arr){
            int x = i%10;
            num = num*10 + x;

        }
        if(num % 10 == 0) System.out.println("Yes");
        else System.out.println("No");
    }
}



