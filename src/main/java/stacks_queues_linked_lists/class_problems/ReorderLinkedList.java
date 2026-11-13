package stacks_queues_linked_lists.class_problems;

public class ReorderLinkedList {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static void reorderList(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverse(slow.next);
        slow.next = null;
        Node first = head;

        while (second != null) {
            Node firstNext = first.next;
            Node secondNext = second.next;
            first.next = second;
            second.next = firstNext;
            first = firstNext;
            second = secondNext;
        }
    }

    private static Node reverse(Node head) {
        Node previous = null, current = head;
        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }
}
// Time: O(n), Space: O(1). Reuses existing nodes only.