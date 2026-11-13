package stacks_queues_linked_lists.class_problems;

public class RemoveNthNodeFromEnd {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node removeNthFromEnd(Node head, int n) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node fast = dummy;
        Node slow = dummy;

        for (int i = 0; i < n; i++) fast = fast.next;
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;
        return dummy.next;
    }
}
// Time: O(n), Space: O(1).