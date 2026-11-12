import java.util.Scanner;

public class fRemoveNth {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode removeNthFromEnd(ListNode head, int n) {

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode slow = dummy;
        ListNode fast = dummy;

        // Move fast pointer N steps ahead
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }

        // Move both pointers until fast reaches the last node
        while (fast.next != null) {

            slow = slow.next;
            fast = fast.next;
        }

        // Remove the Nth node from the end
        slow.next = slow.next.next;

        return dummy.next;
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

        int size = sc.nextInt();

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < size; i++) {

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

        int n = sc.nextInt();

        head = removeNthFromEnd(head, n);

        if (head == null) {
            System.out.println("Empty list");
        } else {
            printList(head);
        }

        sc.close();
    }
}