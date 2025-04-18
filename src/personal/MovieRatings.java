package personal;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MovieRatings {
	public static int maxIncreasingAdjacentPairs(List<Integer> ratings) {
		Collections.sort(ratings); // Sorts the list in ascending order
		int n = ratings.size();
		int count = 0;
		int i = 0;
		int j = 1;

		while (j < n) {
			if (ratings.get(i) < ratings.get(j)) {
				count++;
				i++;
			}
			j++;
		}

		return count;
	}

	public static void main(String[] args) {
		List<Integer> ratings = Arrays.asList(4,2,1,2,2);

		System.out.println(maxIncreasingAdjacentPairs(ratings)); // Output: 2
	}
}
