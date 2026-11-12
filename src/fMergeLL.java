import java.util.Scanner;

public class fMergeLL {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {

                current.next = list1;
                list1 = list1.next;

            } else {

                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Attach remaining nodes
        if (list1 != null) {
            current.next = list1;
        }

        if (list2 != null) {
            current.next = list2;
        }

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

        // First linked list
        int n = sc.nextInt();

        ListNode list1 = null;
        ListNode tail1 = null;

        for (int i = 0; i < n; i++) {

            ListNode node = new ListNode(sc.nextInt());

            if (list1 == null) {
                list1 = node;
                tail1 = node;
            } else {
                tail1.next = node;
                tail1 = node;
            }
        }

        // Second linked list
        int m = sc.nextInt();

        ListNode list2 = null;
        ListNode tail2 = null;

        for (int i = 0; i < m; i++) {

            ListNode node = new ListNode(sc.nextInt());

            if (list2 == null) {
                list2 = node;
                tail2 = node;
            } else {
                tail2.next = node;
                tail2 = node;
            }
        }

        ListNode merged = mergeTwoLists(list1, list2);

        printList(merged);

        sc.close();
    }
}
