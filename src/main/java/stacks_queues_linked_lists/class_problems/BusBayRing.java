package stacks_queues_linked_lists.class_problems;

public class BusBayRing {
    private final int[] buses;
    private int front;
    private int size;

    public BusBayRing(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        buses = new int[capacity];
    }

    public boolean insertFront(int bus) {
        if (isFull()) return false;
        front = (front - 1 + buses.length) % buses.length;
        buses[front] = bus;
        size++;
        return true;
    }

    public boolean insertLast(int bus) {
        if (isFull()) return false;
        int rear = (front + size) % buses.length;
        buses[rear] = bus;
        size++;
        return true;
    }

    public boolean deleteFront() {
        if (isEmpty()) return false;
        front = (front + 1) % buses.length;
        size--;
        return true;
    }

    public boolean deleteLast() {
        if (isEmpty()) return false;
        size--;
        return true;
    }

    public int getFront() {
        return isEmpty() ? -1 : buses[front];
    }

    public int getRear() {
        if (isEmpty()) return -1;
        return buses[(front + size - 1) % buses.length];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == buses.length;
    }

    public static void main(String[] args) {
        BusBayRing bay = new BusBayRing(3);
        System.out.println(bay.insertLast(101));
        System.out.println(bay.insertLast(102));
        System.out.println(bay.insertFront(100));
        System.out.println(bay.insertFront(99));
        System.out.println(bay.getRear());
        System.out.println(bay.isFull());
        System.out.println(bay.deleteLast());
        System.out.println(bay.insertFront(98));
        System.out.println(bay.getFront());
    }
}

// Every operation: O(1) time; O(capacity) space for the fixed array.
