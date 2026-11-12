import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class hLeastCommon {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Find a node using its value
    static TreeNode findNode(TreeNode root, int value) {

        if (root == null) {
            return null;
        }

        if (root.val == value) {
            return root;
        }

        TreeNode leftResult = findNode(root.left, value);

        if (leftResult != null) {
            return leftResult;
        }

        return findNode(root.right, value);
    }

    // Find Lowest Common Ancestor
    static TreeNode lowestCommonAncestor(
            TreeNode root,
            TreeNode p,
            TreeNode q) {

        // Base case
        if (root == null || root == p || root == q) {
            return root;
        }

        // Search left subtree
        TreeNode left = lowestCommonAncestor(
            root.left, p, q
        );

        // Search right subtree
        TreeNode right = lowestCommonAncestor(
            root.right, p, q
        );

        // Both nodes found in different subtrees
        if (left != null && right != null) {
            return root;
        }

        // Return whichever subtree found a target
        return left != null ? left : right;
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

        int pValue = sc.nextInt();
        int qValue = sc.nextInt();

        TreeNode root = buildTree(values);

        TreeNode p = findNode(root, pValue);
        TreeNode q = findNode(root, qValue);

        if (p == null || q == null) {

            System.out.println("Node not found");

        } else {

            TreeNode lca = lowestCommonAncestor(root, p, q);

            System.out.println(lca.val);
        }

        sc.close();
    }
}