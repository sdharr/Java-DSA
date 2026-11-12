import java.util.Scanner;

public class fAddNumbers {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);

        ListNode current = dummy;

        int carry = 0;

        while (l1 != null || l2 != null || carry != 0) {

            int sum = carry;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            int digit = sum % 10;

            carry = sum / 10;

            current.next = new ListNode(digit);

            current = current.next;
        }

        return dummy.next;
    }

    static ListNode buildList(Scanner sc, int n) {

        ListNode head = null;
        ListNode tail = null;

        for (int i = 0; i < n; i++) {

            int digit = sc.nextInt();

            ListNode newNode = new ListNode(digit);

            if (head == null) {

                head = newNode;
                tail = newNode;

            } else {

                tail.next = newNode;
                tail = newNode;
            }
        }

        return head;
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

        ListNode l1 = buildList(sc, n);

        int m = sc.nextInt();

        ListNode l2 = buildList(sc, m);

        ListNode result = addTwoNumbers(l1, l2);

        printList(result);

        sc.close();
    }
}