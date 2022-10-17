package hacker_rank;

import java.util.LinkedList;
import java.util.Scanner;

public class JavaList {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        LinkedList<Integer> ll = new LinkedList<>();
        for (int i = 0; i < n; i++)
            ll.add(sc.nextInt());
        int t = sc.nextInt();
        while (t --> 0) {
            t--;
            System.out.println(t);
            switch (sc.next()) {
                case "Insert" -> ll.add(sc.nextInt(), sc.nextInt());
                case "Delete" -> ll.remove(sc.nextInt());
            }
        }
        ll.remove(0);
        for(int i: ll)
            System.out.print(i+" ");
    }
}
