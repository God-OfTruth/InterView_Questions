package leet_code;

import java.util.ArrayList;
import java.util.List;

public class DeleteColumnsToMakeSortedString {
    public static void main(String[] args) {
        String[] arr = {"abc", "bce", "cae"};
        System.out.println(minDeletionSize(arr));
    }
    private static int minDeletionSize(String[] strs) {
        int n = strs.length, m = strs[0].length(), ans = 0;
        List<Integer> arr = new ArrayList<>();
        for(int j = 0; j < m; j++){
            int prev = 0;
            boolean toBeDeleted = false;
            for (String str : strs) {
                int cur = str.charAt(j) - 'a';
                if (cur >= prev) {   // update prev if we get a larger character
                    prev = cur;
                } else {
                    toBeDeleted = true;
                    break;
                }
            }
            if(toBeDeleted) ans++;
        }
        return ans;
    }
}

/*
* a b c
* b c e
* c a e
*
* a b c
* b c a
* c e e
* */
