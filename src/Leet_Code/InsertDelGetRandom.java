package Leet_Code;

import java.util.*;

public class InsertDelGetRandom {
	public static void main(String[] args) {
		RandomizedSet set = new RandomizedSet();
		System.out.println(set.insert(1));
		System.out.println(set.remove(2));
		System.out.println(set.insert(2));
		System.out.println(set.getRandom());
		System.out.println(set.remove(1));
		System.out.println(set.insert(2));
		System.out.println(set.getRandom());
	}
}

class RandomizedSet {
	Set<Integer> set;
	List<Integer> integers;

	public RandomizedSet() {
		this.set = new HashSet<>();
		this.integers = new LinkedList<>();
	}

	public boolean insert(int val) {
		if (set.add(val)) {
			integers.add(val);
			return true;
		}
		return false;
	}

	public boolean remove(int val) {
		if (set.remove(val)){
			integers.remove((Integer) val);
			return true;
		}
		return false;
	}

	public int getRandom() {
		Random random = new Random();
		return integers.get(random.nextInt(set.size()));
	}
}
