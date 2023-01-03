package leet_code;

public class PivotedIndex {

	public static void main(String[] args) {
		System.out.println(pivot_Index(new
				int[]{-1, -1, 0, 1, 1, 0}));
	}

	public static int pivot_Index(int[] nums) {
		int p = 0;
		int s = 0;
		for (int i : nums) s += i;
		int cs = 0;
		while (p < nums.length) {
			cs += nums[p];
			s -= nums[p];
			if (s == cs - nums[p]) return p;
			p++;
		}
		return -1;
	}
}