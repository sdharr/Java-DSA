import java.util.Scanner;

public class fIntersection {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    // Build a linked list prefix and attach a shared tail
    static ListNode buildPrefix(int[] values, ListNode sharedHead) {

        ListNode head = sharedHead;

        for (int i = values.length - 1; i >= 0; i--) {

            ListNode node = new ListNode(values[i]);

            node.next = head;

            head = node;
        }

        return head;
    }

    static ListNode getIntersectionNode(
            ListNode headA,
            ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {

            if (a == null) {
                a = headB;
            } else {
                a = a.next;
            }

            if (b == null) {
                b = headA;
            } else {
                b = b.next;
            }
        }

        return a;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Number of nodes in independent prefixes
        int n1 = sc.nextInt();
        int n2 = sc.nextInt();

        // Number of nodes in the shared tail
        int sharedCount = sc.nextInt();

        int[] prefixA = new int[n1];
        int[] prefixB = new int[n2];
        int[] sharedValues = new int[sharedCount];

        // Read first list's independent nodes
        for (int i = 0; i < n1; i++) {
            prefixA[i] = sc.nextInt();
        }

        // Read second list's independent nodes
        for (int i = 0; i < n2; i++) {
            prefixB[i] = sc.nextInt();
        }

        // Read shared tail nodes
        for (int i = 0; i < sharedCount; i++) {
            sharedValues[i] = sc.nextInt();
        }

        // Build shared linked list only once
        ListNode sharedHead = null;

        for (int i = sharedCount - 1; i >= 0; i--) {

            ListNode node = new ListNode(sharedValues[i]);

            node.next = sharedHead;

            sharedHead = node;
        }

        // Attach both lists to the SAME shared nodes
        ListNode headA = buildPrefix(prefixA, sharedHead);

        ListNode headB = buildPrefix(prefixB, sharedHead);

        // Find intersection
        ListNode intersection =
                getIntersectionNode(headA, headB);

        if (intersection != null) {

            System.out.println(
                "Intersection at node value = " + intersection.val
            );

        } else {

            System.out.println("No intersection");
        }

        sc.close();
    }
}