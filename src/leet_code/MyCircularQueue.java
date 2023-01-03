package leet_code;

import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {
	final List<Integer> queue;
	int length;

	public MyCircularQueue(int k) {
		this.queue = new ArrayList<>();
		this.length = k;
	}

	public boolean enQueue(int value) {
		if (this.length <= 0) {
			return false;
		}
		this.queue.add(0, value);
		this.length = this.length - 1;
		return true;
	}

	public boolean deQueue() {
		if (this.queue.isEmpty()) {
			return false;
		}
		this.queue.remove(this.queue.size() - 1);
		this.length = this.length + 1;
		return true;
	}

	public int Front() {
		if (this.queue.isEmpty()) return -1;
		return this.queue.get(this.queue.size() - 1);
	}

	public int Rear() {
		if (this.queue.isEmpty()) return -1;
		return this.queue.get(0);
	}

	public boolean isEmpty() {
		return !isFull();
	}

	public boolean isFull() {
		return this.length == 0;
	}
}