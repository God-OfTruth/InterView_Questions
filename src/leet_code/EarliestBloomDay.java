package leet_code;

import java.util.Arrays;

class Seed {
	public final int p;
	public final int g;

	public Seed(int p, int g) {
		this.p = p;
		this.g = g;
	}
}

public class EarliestBloomDay {
	public static void main(String[] args) {
		int[] plant = {1};
		int[] grow = {1};
		System.out.println(earliestFullBloom(plant, grow));
	}

	public static int earliestFullBloom(int[] plantTime, int[] growTime) {
		int ans = 0;
		int time = 0;
		Seed[] seeds = new Seed[plantTime.length];

		for (int i = 0; i < plantTime.length; ++i)
			seeds[i] = new Seed(plantTime[i], growTime[i]);

		Arrays.sort(seeds, (a, b) -> b.g - a.g);

		for (Seed seed : seeds) {
			time += seed.p;
			ans = Math.max(ans, time + seed.g);
		}
		return ans;
	}
}
