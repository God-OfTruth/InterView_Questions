package GFG;

public class Piggibanks {

    public static void main(String[] args) {
        int[] arr = new int[]{1,5,2,4,7};
        int[] arr2 = new int[]{7,9,6};
        System.out.println(piggyBank(5,3, arr, arr2));
    }
//    public static int piggyBank(int input1 ,int input2, int[] input3, int[] input4)
//    {
//        int[] ans=new int[1];
//        int[] data=new int[input2];
//        comb(input3,input1,input2,0,data,0,ans);
//
//        return ans[0];
//    }
//    static void comb(int[] arr, int n, int r, int index,
//                     int[] data, int i,int[] ans)
//    {
//        if (index == r)
//        {
//            for (int j=0; j<r; j++);
//            ans[0]++;
//            return;
//        }
//        if (i >= n)
//            return;
//        data[index] = arr[i];
//        comb(arr, n, r, index+1, data, i+1,ans);
//        comb(arr, n, r, index, data, i+1,ans);
//    }
public static int piggyBank(int input1,int input2, int[] input3, int[] input4)
{
    int[] ans=new int[1];
    int[] data = new int[input1];
    comb(input3, input1, input2,0, data,0, ans);

    return ans[0];
}
    static void comb(int[] arr, int n, int r, int index, int[] data, int i,int[] ans)
    {
        if (index == r)
        {
            for (int j=0; j<r; j++)
                ans[0]++;
            return;
        }
        if (i >= n)
            return;
        data[index] = arr[i];
        comb(arr, n, r, index+1, data, i+1,ans);
        comb(arr, n, r, index, data, i+1,ans);

    }
}


