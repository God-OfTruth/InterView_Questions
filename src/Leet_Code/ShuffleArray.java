package Leet_Code;

import java.util.Arrays;

public class ShuffleArray {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(shuffle(new int[]{2,5,1,3,4,7}, 3)));
    }
    public static int[] shuffle(int[] nums, int n) {
        int[] res = new int[2 * n];
        int i = 0;
        int j = n;
        int curr = 0;
        while (i < n) {
            res[curr] = nums[i];
            curr++;
            i++;
            res[curr] = nums[j];
            curr++;
            j++;
        }
        return res;
    }
}
