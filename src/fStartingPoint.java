import java.util.Scanner;

public class fStartingPoint {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode detectCycle(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;

        // Phase 1: Detect the cycle
        while (fast != null && fast.next != null) {

            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        // No cycle exists
        if (fast == null || fast.next == null) {
            return null;
        }

        // Phase 2: Find the starting node
        slow = head;

        while (slow != fast) {

            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        ListNode[] nodes = new ListNode[n];

        for (int i = 0; i < n; i++) {

            nodes[i] = new ListNode(sc.nextInt());

            if (i > 0) {
                nodes[i - 1].next = nodes[i];
            }
        }

        int pos = sc.nextInt();

        ListNode head = n == 0 ? null : nodes[0];

        // Create cycle if pos is not -1
        if (pos != -1) {
            nodes[n - 1].next = nodes[pos];
        }

        ListNode cycleStart = detectCycle(head);

        if (cycleStart == null) {

            System.out.println(-1);

        } else {

            int index = 0;
            ListNode current = head;

            while (current != cycleStart) {
                current = current.next;
                index++;
            }

            System.out.println(index);
        }

        sc.close();
    }
}
