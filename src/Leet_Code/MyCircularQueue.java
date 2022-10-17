package Leet_Code;

import java.util.ArrayList;
import java.util.List;

class MyCircularQueue {
    List<Integer> queue;
    int length;
    public MyCircularQueue(int k) {
        this.queue = new ArrayList<>();
        this.length = k;
    }

    public boolean enQueue(int value) {
        if(this.length <= 0){
            return false;
        }
        this.queue.add(0, value);
        this.length = this.length-1;
        return true;
    }

    public boolean deQueue() {
        if(this.queue.isEmpty()){
            return false;
        }
        this.queue.remove(this.queue.size()-1);
        this.length = this.length+1;
        return true;
    }

    public int Front() {
        if(this.queue.isEmpty()) return -1;
        return this.queue.get(this.queue.size()-1);
    }

    public int Rear() {
        if(this.queue.isEmpty()) return -1;
        return this.queue.get(0);
    }

    public boolean isEmpty() {
        return !isFull();
    }

    public boolean isFull() {
        return this.length == 0;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */