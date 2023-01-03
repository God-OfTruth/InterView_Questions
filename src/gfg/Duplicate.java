package gfg;


import java.util.*;

class Duplicate {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            ArrayList<Integer> ans = duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
    public static ArrayList<Integer> duplicates(int[] arr, int n) {
        // code here
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int num : arr) {
            if (set.contains(num) && !result.contains(num)) {
                result.add(num);
            } else {
                set.add(num);
            }
        }
        if (result.isEmpty()){
            result.add(-1);
            return result;
        }
        Collections.sort(result);
        return result;
    }
}


