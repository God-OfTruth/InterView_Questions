package leet_code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DecompressTheEncodedList {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(decompressRLElist(new int[]{1, 2, 3, 4})));
    }

    public static int[] decompressRLElist(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2)
            for (int j = 0; j < nums[i]; j++)
                res.add(nums[i + 1]);
        int[] ans = new int[res.size()];
        for (int i=0; i< ans.length; i++)
            ans[i] = res.get(i);
        return ans;
    }
}
