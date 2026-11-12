import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class hInsertValueBST {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Insert a value into BST
    static TreeNode insertIntoBST(TreeNode root, int val) {

        TreeNode newNode = new TreeNode(val);

        // Handle empty tree
        if (root == null) {
            return newNode;
        }

        TreeNode current = root;

        while (true) {

            // Move towards left subtree
            if (val < current.val) {

                if (current.left == null) {

                    current.left = newNode;
                    break;

                } else {

                    current = current.left;
                }
            }

            // Move towards right subtree
            else if (val > current.val) {

                if (current.right == null) {

                    current.right = newNode;
                    break;

                } else {

                    current = current.right;
                }
            }

            // Duplicate value: do nothing
            else {
                break;
            }
        }

        return root;
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

        Queue<TreeNode> queue = new LinkedList<>();

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

    // Print tree in level-order format
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

        int val = sc.nextInt();

        TreeNode root = buildTree(values);

        root = insertIntoBST(root, val);

        System.out.println(levelOrder(root));

        sc.close();
    }
}