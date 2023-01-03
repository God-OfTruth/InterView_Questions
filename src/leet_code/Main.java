package leet_code;

public class Main {
    public static void main(String[] args) {
        MyCircularQueue obj = new MyCircularQueue(3);
        System.out.println(obj.length);
        System.out.println(obj.enQueue(7) + " " + obj.length + " " + obj.queue);
        System.out.println(obj.deQueue() + " " + obj.length + " " + obj.queue);
        System.out.println(obj.Front());
        System.out.println(obj.deQueue() + " " + obj.length + " " + obj.queue);
        System.out.println(obj.Front());
        System.out.println(obj.Rear());
        System.out.println(obj.enQueue(0) + " " + obj.length + " " + obj.queue);
        System.out.println(obj.isFull() + " " + obj.length + " " + obj.queue);
//        System.out.println(obj.isEmpty() + " " + obj.length + " " + obj.queue);
        System.out.println(obj.deQueue() + " " + obj.length + " " + obj.queue);
        System.out.println(obj.Rear());
        System.out.println(obj.enQueue(3) + " " + obj.length + " " + obj.queue);
        System.out.println(obj.queue + " " + obj.length + " " + obj.queue);
    }
}

// ["MyCircularQueue","enQueue","enQueue","enQueue","enQueue","deQueue","deQueue","isEmpty","isEmpty","Rear","Rear","deQueue"]
// [[8],[3],[9],[5],[0],[],[],[],[],[],[],[]]

// ["MyCircularQueue","enQueue","deQueue","Front","deQueue","Front","Rear","enQueue","isFull","deQueue","Rear","enQueue"]
// [[3],[7],[],[],[],[],[],[0],[],[],[],[3]]