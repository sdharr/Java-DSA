import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class hIdenticalBT {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Check whether two trees are identical
    static boolean isSameTree(TreeNode p, TreeNode q) {

        // Both nodes are null
        if (p == null && q == null) {
            return true;
        }

        // Only one node is null
        if (p == null || q == null) {
            return false;
        }

        // Compare values and both subtrees
        return p.val == q.val
                && isSameTree(p.left, q.left)
                && isSameTree(p.right, q.right);
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

        // Read first tree
        int n = sc.nextInt();

        String[] values1 = new String[n];

        for (int i = 0; i < n; i++) {
            values1[i] = sc.next();
        }

        // Read second tree
        int m = sc.nextInt();

        String[] values2 = new String[m];

        for (int i = 0; i < m; i++) {
            values2[i] = sc.next();
        }

        TreeNode root1 = buildTree(values1);

        TreeNode root2 = buildTree(values2);

        System.out.println(isSameTree(root1, root2));

        sc.close();
    }
}
