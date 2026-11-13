package stacks_queues_linked_lists.class_problems;

public class AddTwoNumbers {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static Node addNumbers(Node a, Node b) {
        Node dummy = new Node(0), tail = dummy;
        int carry = 0;

        while (a != null || b != null || carry != 0) {
            int sum = carry;
            if (a != null) { sum += a.data; a = a.next; }
            if (b != null) { sum += b.data; b = b.next; }

            tail.next = new Node(sum % 10);
            tail = tail.next;
            carry = sum / 10;
        }
        return dummy.next;
    }
}
// Time: O(max(m, n)), Space: O(max(m, n)) for the result.