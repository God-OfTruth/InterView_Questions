package leet_code;

import java.util.*;
public class RichestCustomerWealth
{
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int m=sc.nextInt();
		int n=sc.nextInt();
		int[][] arr= new int[m][n];
		for(int i=0; i<m; i++)
		    for(int j=0; j<n; j++)
		        arr[i][j] = sc.nextInt();
        int maxSum=0, x=0;
        ArrayList<Integer> sum = new ArrayList<>();
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                maxSum+=arr[i][j];
            }
            sum.add(maxSum);
            maxSum=0;
        }
            
        
        Collections.sort(sum);
        System.out.println(sum.get(sum.size()-1));
		
	}
}
