package stacks_queues_linked_lists.class_problems;

public class FindIntersectionNode {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node findIntersection(Node a, Node b) {
        int lengthA = length(a), lengthB = length(b);

        while (lengthA > lengthB) { a = a.next; lengthA--; }
        while (lengthB > lengthA) { b = b.next; lengthB--; }

        while (a != b) {
            a = a.next;
            b = b.next;
        }
        return a;
    }

    private static int length(Node head) {
        int count = 0;
        while (head != null) { count++; head = head.next; }
        return count;
    }
}
// Time: O(m + n), Space: O(1). Compares node references, not values.