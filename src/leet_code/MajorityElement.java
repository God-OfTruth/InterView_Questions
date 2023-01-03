package leet_code;

import java.util.HashMap;
import java.util.Map;

public class MajorityElement {
    public static void main(String[] args) {
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
