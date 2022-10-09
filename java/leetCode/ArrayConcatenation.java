package Leet_Code;

import java.util.Arrays;

public class ArrayConcatenation {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(getConcatenation(new int[]{1, 2, 1})));
    }
    public static int[] getConcatenation(int[] nums) {
        int[] ans = new int[nums.length * 2];
        System.arraycopy(nums, 0, ans, 0, nums.length);
        System.arraycopy(nums, 0, ans, 3, nums.length);
        return ans;
    }
}
