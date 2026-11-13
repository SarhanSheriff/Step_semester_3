package stacks_queues_linked_lists.assignment_problems;

public class PalindromeTrainCode {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static boolean isPalindrome(Node head) {
        if (head == null || head.next == null) return true;

        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        Node secondHalf = reverse(slow.next);
        Node first = head;
        Node second = secondHalf;
        boolean matches = true;

        while (second != null) {
            if (first.data != second.data) {
                matches = false;
                break;
            }
            first = first.next;
            second = second.next;
        }

        slow.next = reverse(secondHalf);
        return matches;
    }

    private static Node reverse(Node head) {
        Node previous = null;
        Node current = head;

        while (current != null) {
            Node next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }
        return previous;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(2);
        head.next.next.next.next = new Node(1);

        System.out.println(isPalindrome(head));
    }
}

// Time: O(n), Space: O(1); restores the list before returning.
