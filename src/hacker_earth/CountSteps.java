package hacker_earth;

import java.util.Scanner;

class CountSteps {
    public static void main(String args[] ) throws Exception {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int[] b = new int[n];
        for(int i=0; i<n; i++){
            System.out.println('a');
            a[i] = sc.nextInt();

        }
//        System.out.println(a);
        for(int i=0; i<n; i++){
            System.out.println(b);

            b[i] = sc.nextInt();
        }
//        System.out.println(b);

//        sc.close();
        int steps = countSteps(a, b);
        System.out.println(steps);
    }
    public static boolean checkEqual(int[] a, int[] b){
        System.out.println("Check Equal");

        for(int i=0; i<a.length; i++)
            if (a[i] != b[i]) return false;
        return true;
    }
    public static boolean checkGreater(int[] a, int[] b){
        System.out.println("check Greater");
        for(int i=0; i<a.length; i++)
            if (a[i] >= b[i]) return true;
        return false;
    }
    public static int countSteps(int[] a, int[] b){
        System.out.println("Steps Count");
        if(a.length != b.length) return -1;
        int count = 0;
        int n = a.length;
        boolean c = checkEqual(a, b);
        boolean v = checkGreater(a, b);
        while (!c || v){
            count++;
            for (int i=0; i<n; i++){
                if (a[i] > b[i]){
                    a[i]-=b[i];
                }
            }
            c= checkEqual(a, b);
        }
        System.out.println(count);
        return count;
    }
}
