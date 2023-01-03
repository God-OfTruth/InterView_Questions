package gfg;

public class ChicksInAZoo {
	public static void main(String[] args) {
		System.out.println(NoOfChicks(7));
	}

	public static long NoOfChicks(int n) {
		long[] newChick = new long[n];
		newChick[0] = 1;
		long chick = 1;
		for (int i=1; i<n; i++){
			if (i >= 6) chick -= newChick[i-6];
			newChick[i] = chick * 2;
			chick += newChick[i];
		}
		return chick;
	}
}
