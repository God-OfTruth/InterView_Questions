package Leet_Code;

import java.util.Scanner;

public class SearchInsertPos {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i=0; i< n; i++){
            arr[i] = sc.nextInt();
        }
        int target = sc.nextInt();
        System.out.println(searchInsert(arr, target));
    }
    public static int searchInsert(int[] nums, int target) {
        int start = 0;
        int end = nums.length - 1;
        while( start <= end ) {
            int mid = (start + end) / 2;
            if(nums[mid] == target) {
                return mid;
            }
            else if (target > nums[mid]) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
        return end + 1;
    }
}
