package gfg;

import java.util.Scanner;

public class Equilibrium {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i=0; i<n; i++)
            arr[i] = sc.nextLong();
        System.out.println(equilibriumPoint(arr, n));
    }
    public static int equilibriumPoint(long[] arr, int n) {
        long fullSum = sum(arr);
        System.out.println(fullSum);
        long halfSum = 0;
        for(int i=0; i<n; i++){
            halfSum += arr[i];
            System.out.println(fullSum+" updated "+halfSum);
            if(halfSum == fullSum){
                System.out.println(fullSum+" checked "+halfSum);
                return i+1;
            }
            fullSum -= arr[i];
        }
        return -1;
    }
    public static long sum(long[] arr){
        long s = 0;
        for(long i: arr)
            s+=i;
        return s;
    }
}
