import java.util.Scanner;
import java.util.PriorityQueue;

public class iMergeKSortedLinkedLists {

    static class ListNode {

        int val;
        ListNode next;

        ListNode(int val) {
            this.val = val;
            this.next = null;
        }
    }

    static ListNode mergeKLists(ListNode[] lists) {

        // Create Min Heap
        PriorityQueue<ListNode> heap =
                new PriorityQueue<>(
                    (a, b) -> Integer.compare(a.val, b.val)
                );

        // Add the first node of every non-empty list
        for (ListNode node : lists) {

            if (node != null) {
                heap.offer(node);
            }
        }

        ListNode dummy = new ListNode(0);

        ListNode tail = dummy;

        // Process nodes in ascending order
        while (!heap.isEmpty()) {

            // Remove smallest node
            ListNode node = heap.poll();

            // Add its next node to the heap
            if (node.next != null) {
                heap.offer(node.next);
            }

            // Attach smallest node to result
            tail.next = node;

            tail = tail.next;
        }

        // End the resulting linked list
        tail.next = null;

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

        int k = sc.nextInt();

        ListNode[] lists = new ListNode[k];

        // Read K sorted linked lists
        for (int i = 0; i < k; i++) {

            int n = sc.nextInt();

            ListNode head = null;
            ListNode tail = null;

            for (int j = 0; j < n; j++) {

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

            lists[i] = head;
        }

        ListNode result = mergeKLists(lists);

        printList(result);

        sc.close();
    }
}