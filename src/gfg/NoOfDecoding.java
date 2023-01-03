package gfg;

import java.util.Scanner;

public class NoOfDecoding {
    static final int mod = 1000000007;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        System.out.println(countDecodings(str));
    }

    public static int decodeMessage(int[] dp, int s, String str, int n) {
        if(s >= n)
            return 1;
        if(dp[s] != -1)
            return dp[s];

        int num,tc;
        num = tc = 0;
        for(int i=s;i<n;i++) {
            num = num*10 + ((int)str.charAt(i) - '0');
            if(num >= 1 && num <= 26) {
                int c = decodeMessage(dp, i + 1, str, n);
                tc = (tc%mod + c%mod)%mod;
            }
            else
                break;
        }
        return (dp[s] = tc);
    }
    public static int countDecodings(String input1){
        int n = input1.length();
        if(n == 0)
            return 1;
        int[] dp = new int[n];
        for(int i = 0; i < n; i++){
            dp[i] = -1;
        }
        return decodeMessage(dp,0,input1,n);
    }
}
