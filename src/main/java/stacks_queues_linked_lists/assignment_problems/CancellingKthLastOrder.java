package stacks_queues_linked_lists.assignment_problems;

public class CancellingKthLastOrder {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node removeKthFromEnd(Node head, int k) {
        Node dummy = new Node(0);
        dummy.next = head;
        Node lead = dummy;
        Node trail = dummy;

        for (int i = 0; i <= k; i++) {
            lead = lead.next;
        }

        while (lead != null) {
            lead = lead.next;
            trail = trail.next;
        }

        trail.next = trail.next.next;
        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        printList(removeKthFromEnd(head, 2));
    }
}

// Time: O(n), Space: O(1); one traversal with lead and trail pointers.
