package gfg;

public class MagicTriplets {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		System.out.println(countTriplets(nums));
	}

	public static int countTriplets(int[] arr) {
		int max_sum = 0;
		int n = arr.length;
		for (int i = 1; i * i <= n; i++)
			if (n % i == 0) {
				max_sum += i;
				if (n / i != i)
					max_sum += (n / i);
			}
		return max_sum;
	}
}
