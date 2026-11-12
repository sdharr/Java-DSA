import java.util.Scanner;

public class fDetectCycle {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static boolean hasCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }

        return false;
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

        int pos = sc.nextInt();

        // Create a cycle if pos is not -1
        if (pos != -1) {

            ListNode cycleNode = head;

            for (int i = 0; i < pos; i++) {
                cycleNode = cycleNode.next;
            }

            tail.next = cycleNode;
        }

        boolean result = hasCycle(head);

        System.out.println(result);

        sc.close();
    }
}