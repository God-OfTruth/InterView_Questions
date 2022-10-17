package hacker_rank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DynamicArray {
    public static void main(String[] args) {
        int n = 2;
        List<List<Integer>> queries = Arrays.asList(
                Arrays.asList(1, 0, 5),
                Arrays.asList(1, 1, 7),
                Arrays.asList(1, 0, 3),
                Arrays.asList(2, 1, 0),
                Arrays.asList(2, 1, 1));

        List<Integer> res = dynamicArray(n, queries);
        System.out.println(res);
    }

    public static int XOR(int x, int y) {
        return x^y;
    }
    public static List<Integer> dynamicArray(int n, List<List<Integer>> queries) {
        // Write your code here
        List<List<Integer>> arr = new ArrayList<>(n);
        List<Integer> res = new ArrayList<>();
        for(int i=0; i< n; i++)
            arr.add(new ArrayList<>());
        int lastAnswer = 0;
        for (List<Integer> l : queries){
            int x = l.get(1);
            int y = l.get(2);
            int idx = (XOR(x, lastAnswer) % n);
            switch (l.get(0)){
                case 1:
                    arr.get(idx).add(y);
                    break;
                case 2:
                    lastAnswer = arr.get(idx).get(y%(arr.get(idx).size()));
                    res.add(lastAnswer);
                    break;
            }
        }
        return res;
    }
}
