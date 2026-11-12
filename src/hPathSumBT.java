import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class hPathSumBT {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Check whether a root-to-leaf path has target sum
    static boolean hasPathSum(TreeNode root, long targetSum) {

        // Empty tree cannot have a path
        if (root == null) {
            return false;
        }

        // Subtract current node's value
        targetSum -= root.val;

        // Check whether current node is a leaf
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }

        // Search left and right subtrees
        return hasPathSum(root.left, targetSum)
                || hasPathSum(root.right, targetSum);
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

        long targetSum = sc.nextLong();

        TreeNode root = buildTree(values);

        System.out.println(hasPathSum(root, targetSum));

        sc.close();
    }
}
