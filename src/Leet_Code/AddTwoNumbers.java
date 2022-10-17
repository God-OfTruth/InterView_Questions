package Leet_Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AddTwoNumbers {
    public static void main(String[] args) {
        List<Integer> l1 = Arrays.asList(1,3,6);
        List<Integer> l2 = Arrays.asList(3,3,9);
        addNumbers(l1, l2).forEach(System.out::print);
    }

    private static List<Integer> addNumbers(List<Integer> l1, List<Integer> l2) {
        int s1 = 0;
        int s2 = 0;
        List<Integer> res = new ArrayList<>();
        for (int i : l1){
            s1 = s1*10 + i;
        }
        for (int i : l2){
            s2 = s2*10 + i;
        }
        int r = s1 + s2;
        while (r != 0) {
            int rem = r%10;
            res.add(res.size(), rem);
            r = r/10;
        }
        return res;
    }
}
