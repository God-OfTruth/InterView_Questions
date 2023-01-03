package gfg;

import java.util.Scanner;

public class FindMaxSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        sc.close();
        int res = findMaxSum(arr, n);
        System.out.println(res);
    }
    public static int findMaxSum(int[] arr, int n){
        if(n == 1) return arr[0];
        if(n == 2) return Math.max(arr[0], arr[1]);
        if (n==3) return Math.max(arr[1], arr[0]+arr[2]);
        int s = 0;
        for (int j=0; j<n; j++){
            int sum = 0;
            for (int i=j; i<n; i+=2){
                System.out.print(arr[i] + " ");
                sum+=arr[i];
            }
            System.out.println();
            s= Math.max(s, sum);
        }
        System.out.println();
        return s;
    }
}
