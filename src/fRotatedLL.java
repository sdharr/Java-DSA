import java.util.Scanner;

public class fRotatedLL {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode rotateRight(ListNode head, long k) {

        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        int length = 1;

        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Remove unnecessary rotations
        k = k % length;

        if (k == 0) {
            return head;
        }

        // Connect tail to head to form a circular list
        tail.next = head;

        // Find the new tail
        long steps = length - k;

        ListNode newTail = head;

        for (int i = 1; i < steps; i++) {
            newTail = newTail.next;
        }

        // Find the new head
        ListNode newHead = newTail.next;

        // Break the circular connection
        newTail.next = null;

        return newHead;
    }

    static void printList(ListNode head) {

        ListNode current = head;

        while (current != null) {

            System.out.print(current.val);

            if (current.next != null) {
                System.out.print(" -> ");
            }

            current = current.next;
        }

        System.out.println();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            ListNode newNode = new ListNode(value);

            if (head == null) {

                head = newNode;
                tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;
            }
        }

        long k = sc.nextLong();

        head = rotateRight(head, k);

        if (head == null) {
            System.out.println("Empty list");
        } else {
            printList(head);
        }

        sc.close();
    }
}