package stacks_queues_linked_lists.class_problems;

public class LinkedListPalindrome {
    static class Node {
        int data;
        Node next;
        Node(int data) { this.data = data; }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node second = reverse(slow.next);
        Node first = head;
        boolean same = true;

        for (Node p = second; p != null; p = p.next) {
            if (first.data != p.data) {
                same = false;
                break;
            }
            first = first.next;
        }

        slow.next = reverse(second);
        return same;
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
// Time: O(n), Space: O(1). Restores the list after checking.