import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class hmaxpathsum{

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int maxSum = Integer.MIN_VALUE;

    // Calculate maximum gain from a node
    static int maxGain(TreeNode root) {

        if (root == null) {
            return 0;
        }

        // Ignore negative contributions
        int leftGain = Math.max(0, maxGain(root.left));

        int rightGain = Math.max(0, maxGain(root.right));

        // Maximum path passing through current node
        int currentPathSum =
                root.val + leftGain + rightGain;

        maxSum = Math.max(maxSum, currentPathSum);

        // Return only one branch to the parent
        return root.val + Math.max(leftGain, rightGain);
    }

    static int maxPathSum(TreeNode root) {

        maxSum = Integer.MIN_VALUE;

        maxGain(root);

        return maxSum;
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

        System.out.println(maxPathSum(root));

        sc.close();
    }
}