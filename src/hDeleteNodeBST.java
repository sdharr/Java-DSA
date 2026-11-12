import java.util.Scanner;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class hDeleteNodeBST {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    // Find the smallest node in a subtree
    static TreeNode findMin(TreeNode root) {

        while (root.left != null) {
            root = root.left;
        }

        return root;
    }

    // Delete a node from BST
    static TreeNode deleteNode(TreeNode root, int key) {

        // Base case
        if (root == null) {
            return null;
        }

        // Search in left subtree
        if (key < root.val) {

            root.left = deleteNode(root.left, key);

        }

        // Search in right subtree
        else if (key > root.val) {

            root.right = deleteNode(root.right, key);

        }

        // Node found
        else {

            // Case 1: No left child
            if (root.left == null) {
                return root.right;
            }

            // Case 2: No right child
            if (root.right == null) {
                return root.left;
            }

            // Case 3: Both children exist

            // Find inorder successor
            TreeNode successor = findMin(root.right);

            // Replace current node's value
            root.val = successor.val;

            // Delete successor from right subtree
            root.right = deleteNode(root.right, successor.val);
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

    // Convert tree into level-order output
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

        int key = sc.nextInt();

        TreeNode root = buildTree(values);

        root = deleteNode(root, key);

        System.out.println(levelOrder(root));

        sc.close();
    }
}