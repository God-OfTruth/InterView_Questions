package hacker_earth;

import java.util.Scanner;

public class BalloonsCost {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            t--;
            int costGreen = sc.nextInt();
            int costPurple = sc.nextInt();
            int n = sc.nextInt();
            int[][] arr = new int[n][2];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < 2; j++) {
                    arr[i][j] = sc.nextInt();
                }
            }
            int cost = calculateCost(costGreen, costPurple, arr);
            System.out.println(cost);

        }
    }
    public static int calculateCost(int costGreen, int costPurple, int[][] arr){
        int cost;
        int topper = 0;
        int p1=0, p2=0;
        for (int[] ints : arr) {
            if (ints[0] == 1 && ints[1] == 1) topper++;
            else if (ints[0] == 1) p1++;
            else if (ints[1] == 1) p2++;
        }
        int c1, c2;
        if (costGreen < costPurple){
            c1 = costGreen;
            c2 = costPurple;
        }else {
            c1 = costPurple;
            c2 = costGreen;
        }

        if (p1 > p2) cost = ((p1*c1) + (p2*c2) + topper*(c1+c2));
        else cost = ((p1*c2) + (p2*c1) + topper*(c1+c2));
        return cost;
    }
}
