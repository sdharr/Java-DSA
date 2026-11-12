import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.Deque;

public class hKthSmallestElement {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Find Kth smallest using iterative inorder traversal
    static int kthSmallest(TreeNode root, int k) {

        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode current = root;

        int count = 0;

        while (current != null || !stack.isEmpty()) {

            // Go as far left as possible
            while (current != null) {

                stack.push(current);

                current = current.left;
            }

            // Visit the next smallest node
            current = stack.pop();

            count++;

            if (count == k) {
                return current.val;
            }

            // Explore right subtree
            current = current.right;
        }

        throw new IllegalArgumentException("Invalid K");
    }

    // Build BST from level-order input
    static TreeNode buildTree(String[] values) {

        if (values.length == 0 ||
            values[0].equalsIgnoreCase("null")) {

            return null;
        }

        TreeNode root = new TreeNode(
            Integer.parseInt(values[0])
        );

        Queue<TreeNode> queue = new ArrayDeque<>();

        queue.offer(root);

        int i = 1;

        while (!queue.isEmpty() && i < values.length) {

            TreeNode current = queue.poll();

            // Left child
            if (i < values.length &&
                !values[i].equalsIgnoreCase("null")) {

                current.left = new TreeNode(
                    Integer.parseInt(values[i])
                );

                queue.offer(current.left);
            }

            i++;

            // Right child
            if (i < values.length &&
                !values[i].equalsIgnoreCase("null")) {

                current.right = new TreeNode(
                    Integer.parseInt(values[i])
                );

                queue.offer(current.right);
            }

            i++;
        }

        return root;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] values = new String[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.next();
        }

        int k = sc.nextInt();

        TreeNode root = buildTree(values);

        System.out.println(kthSmallest(root, k));

        sc.close();
    }
}