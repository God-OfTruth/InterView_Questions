package hacker_rank;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;


public class CompareTwoLinkedList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0){
            t--;
            int n = sc.nextInt();
            List<Integer> l1 = new LinkedList<>();
            for (int i = 0; i < n; i++)
                l1.add(sc.nextInt());
            int m = sc.nextInt();
            List<Integer> l2 = new LinkedList<>();
            for (int i = 0; i < m; i++)
                l2.add(sc.nextInt());

            int res = compareList(n, l1, m, l2);
            System.out.println(res);
        }
    }

    public static int compareList(int n, List<Integer> l1, int m, List<Integer> l2){
        if (m != n) return 0;
        int i = 0;
        for (int x : l1){
            if (x != l2.get(i)) return 0;
            i++;
        }
        return 1;
    }
}
