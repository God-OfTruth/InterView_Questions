package GFG;

import java.util.ArrayList;

public class SubArrayWithGivenSum {
    public static void main(String[] args) {
        System.out.println(subArraySum(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 10, 15));
    }

    //    public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
//        int sum = 0;
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i=0; i<n; i++){
//            int j;
//            for (j=i; j<n; j++) {
//                sum+=arr[j];
//                if (s == sum) break;
//            }
//            if (sum == s) {
//                res.add(i+1);
//                res.add(j+1);
//                break;
//            }
//            sum = 0;
//        }
//        if (!res.isEmpty())
//            return res;
//        res.add(-1);
//        return res;
//    }
    public static ArrayList<Integer> subArraySum(int[] arr, int n, int s) {
        int sum = 0;
        ArrayList<Integer> res = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < n; i++) {
            sum += arr[i];
            while (sum > s && i > j) {
                sum -= arr[j];
                j++;
            }
            if (sum == s) {
                res.add(j + 1);
                res.add(i + 1);
                break;
            }
        }
        return res;
    }
}
