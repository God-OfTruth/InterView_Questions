package Leet_Code;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MajorityElement {
    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//        int n = sc.nextInt();
//        int[] nums = new int[n];
//        for (int i = 0; i < n; i++) {
//            nums[i] = sc.nextInt();
//        }
        int[] nums = new int[]{2,2,1,1,1,2,2};
        System.out.println(majorityElement(nums));
    }
    public static int majorityElement(int[] nums){
        Map<Integer, Integer> map = new HashMap<>();
        for (int i: nums){
            if (map.containsKey(i))
                map.put(i, map.get(i)+1);
            else map.put(i, 1);
        }
        int n = nums.length/2;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer integer = entry.getKey();
            Integer integer2 = entry.getValue();
            if (integer2 > n) return integer;
        }
        return -1;
    }
}
