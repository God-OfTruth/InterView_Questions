package gfg;

import java.util.Scanner;

public class PerfectSum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = sc.nextInt();
        int k = sc.nextInt();
        int res = findSubsets(n, arr, k);
        System.out.println(res);
    }
    public static int findSubsets(int n, int[] arr, int K)
    {
        int x = (int)Math.pow(2, n);
        int count = 0;
        for (int i = 1; i < x; i++)
            count += sumSubsets(arr, i, K);
        return count;
    }
    public static int sumSubsets(int[] set, int n, int target) {

        int[] x = new int[set.length];
        int j = set.length - 1;

        while (n > 0) {
            x[j] = n % 2;
            n = n / 2;
            j--;
        }

        int sum = 0;
        for (int i = 0; i < set.length; i++)
            if (x[i] == 1)
                sum = sum + set[i];

        int count = 0;
        if (sum == target) {
            for (int i = 0; i < set.length; i++) {
                if (x[i] == 1) {
                    count++;
                }

            }
            return count > 0 ? 1: 0;
        }
        return 0;
    }

}
