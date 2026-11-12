import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class hValidateBST {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Validate BST using minimum and maximum boundaries
    static boolean isValidBST(
            TreeNode root,
            long min,
            long max) {

        if (root == null) {
            return true;
        }

        // Current node must lie within valid boundaries
        if (root.val <= min || root.val >= max) {
            return false;
        }

        // Left subtree must contain smaller values
        boolean leftValid = isValidBST(
            root.left,
            min,
            root.val
        );

        // Right subtree must contain greater values
        boolean rightValid = isValidBST(
            root.right,
            root.val,
            max
        );

        return leftValid && rightValid;
    }

    // Build binary tree from level-order input
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

        TreeNode root = buildTree(values);

        boolean result = isValidBST(
            root,
            Long.MIN_VALUE,
            Long.MAX_VALUE
        );

        System.out.println(result);

        sc.close();
    }
}