package GFG;

import java.math.BigInteger;

public class SequenceFun {
	public static void main(String[] args) {
		System.out.println(NthTerm(12));
	}
	public static int NthTerm(int n)
	{
		int prev = 2;
		for(int i=2; i<=n; i++){
			prev = prev*i+1;
		}
		System.out.println(prev);
		return prev;
	}
}
