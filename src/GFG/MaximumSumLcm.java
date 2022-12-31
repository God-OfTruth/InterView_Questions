package GFG;

public class MaximumSumLcm {
	public static void main(String[] args) {
		System.out.println(maxSumLcm(1000000000));
	}

	static long maxSumLcm(int n) {
		long max_sum = 0;
		for (int i = 1; i * i <= n; i++)
			if (n % i == 0) {
				if (n / i == i)
					max_sum += i;
				else max_sum = max_sum + i + n / i;
			}
		return max_sum;
	}
}
