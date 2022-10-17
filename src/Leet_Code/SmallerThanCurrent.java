package Leet_Code;

import java.util.Arrays;

public class SmallerThanCurrent {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(smallerNumbersThanCurrent(new int[]{8, 1, 2, 2, 3})));
    }

    public static int[] smallerNumbersThanCurrent(int[] nums) {
        int[] res = new int[nums.length];
        int[] arr = nums.clone();
        int j = 0;
        Arrays.sort(arr);
        for (int i : nums)
            res[j++] = getIndex(i, arr);
        return res;
    }

    public static int getIndex(int num, int[] arr) {
        for (int i = 0; i < arr.length; i++)
            if (arr[i] == num) return i;
        return -1;
    }
}
