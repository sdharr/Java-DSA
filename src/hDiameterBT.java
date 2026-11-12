import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;

public class hDiameterBT {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int diameter = 0;

    // Calculate height and update diameter
    static int height(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);

        int rightHeight = height(root.right);

        // Longest path passing through current node
        int currentDiameter = leftHeight + rightHeight;

        diameter = Math.max(diameter, currentDiameter);

        // Return height of current subtree
        return 1 + Math.max(leftHeight, rightHeight);
    }

    static int findDiameter(TreeNode root) {

        diameter = 0;

        height(root);

        return diameter;
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

        System.out.println(findDiameter(root));

        sc.close();
    }
}