package hacker_rank;

import java.util.ArrayList;
import java.util.List;

public class HourglassSum {
	public static void main(String[] args) {
		List<List<Integer>> arr = new ArrayList<>();
		arr.add(List.of(1, 1, 1, 0, 0, 0));
		arr.add(List.of(0, 1, 0, 0, 0, 0));
		arr.add(List.of(1, 1, 1, 0, 0, 0));
		arr.add(List.of(0, 0, 0, 0, 0, 0));
		arr.add(List.of(0, 0, 0, 0, 0, 0));
		arr.add(List.of(0, 0, 0, 0, 0, 0));
		System.out.println(hourglassSum(arr));
	}

	public static int hourglassSum(List<List<Integer>> arr) {
		int sum = Integer.MIN_VALUE;
		for (int i = 0; i < arr.get(0).size() - 2; i++)
			for (int j = 0; j < arr.get(0).size() - 2; j++)
				arr.get(i).set(j, arr.get(i).get(j) + arr.get(i).get(j + 1) + arr.get(i + 1).get(j + 1) +
						arr.get(i + 2).get(j) + arr.get(i + 2).get(j + 1) + arr.get(i + 2).get(j + 2));

		for (int i = 0; i < arr.get(0).size() - 2; i++)
			for (int j = 0; j < arr.get(0).size() - 2; j++) if (arr.get(i).get(j) >= sum) sum = arr.get(i).get(j);
		return sum;
	}

}
