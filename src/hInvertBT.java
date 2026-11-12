import java.util.Scanner;
import java.util.Queue;
import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class hInvertBT {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Invert binary tree recursively
    static TreeNode invertTree(TreeNode root) {

        if (root == null) {
            return null;
        }

        // Swap left and right children
        TreeNode temp = root.left;

        root.left = root.right;

        root.right = temp;

        // Invert left subtree
        invertTree(root.left);

        // Invert right subtree
        invertTree(root.right);

        return root;
    }

    // Build tree from level-order input
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

            if (i < values.length &&
                !values[i].equalsIgnoreCase("null")) {

                current.left = new TreeNode(
                    Integer.parseInt(values[i])
                );

                queue.offer(current.left);
            }

            i++;

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

    // Convert inverted tree into level-order output
    static List<String> levelOrder(TreeNode root) {

        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();

        queue.offer(root);

        while (!queue.isEmpty()) {

            TreeNode current = queue.poll();

            if (current == null) {

                result.add("null");

            } else {

                result.add(String.valueOf(current.val));

                queue.offer(current.left);
                queue.offer(current.right);
            }
        }

        // Remove unnecessary trailing nulls
        while (!result.isEmpty() &&
               result.get(result.size() - 1).equals("null")) {

            result.remove(result.size() - 1);
        }

        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        String[] values = new String[n];

        for (int i = 0; i < n; i++) {
            values[i] = sc.next();
        }

        TreeNode root = buildTree(values);

        root = invertTree(root);

        System.out.println(levelOrder(root));

        sc.close();
    }
}