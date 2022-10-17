package GFG;

import java.util.ArrayList;
import java.util.Scanner;

public class David {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n= sc.nextInt();
        int res = training(n);
        System.out.println(res);
    }

    public static int training(int input1){
        if(input1<4)
            return -1;
        else {
            ArrayList<Integer> arr=new ArrayList<>();
            arr.add(0,1);
            arr.add(1,2);
            arr.add(2,3);
            int x=0;
            for(int i=3;i<input1;i++) {
                x =arr.get(i-3)+arr.get(i-2)+arr.get(i-1);
                arr.add(i,x);
            }
            return arr.get(input1-1)%1000000007;
        }
    }

}