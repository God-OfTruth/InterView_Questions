package Leet_Code;

public class PivotedIndex {

    public static void main(String[] args) {
        System.out.println(pivot_Index(new
                int[] {-1,-1,0,1,1,0}));
    }

    public static int pivot_Index(int[] nums) {
//        int left = 0;
//        for (int i = 0; i < nums.length - 1; i++) {
//            int right = 0;
//            for (int j = i + 1; j < nums.length; j++) {
//                right += nums[j];
//                System.out.println(" right -> " + right);
//            }
//            if (right == left) {
//                return i;
//            } else {
//                left += nums[i];
//                System.out.println("-> " + left);
//            }
//        }
//        return -1;
        int p=0;
        int s=0;
        for(int i:nums) s += i;
        int cs=0;
        while(p<nums.length){
            cs+=nums[p];
            s-=nums[p];
            if(s==cs-nums[p]){
                return p;
            }
            p++;
        }
        return -1;
    }
}