import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;
import java.util.Queue;
import java.util.LinkedList;
import java.util.List;
import java.util.ArrayList;

public class hConstructTreePreorderInorder {

    static class TreeNode {

        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int val) {
            this.val = val;
        }
    }

    static int preorderIndex;

    static Map<Integer, Integer> inorderMap;

    // Construct binary tree recursively
    static TreeNode buildTree(
            int[] preorder,
            int left,
            int right) {

        // No elements in this subtree
        if (left > right) {
            return null;
        }

        // Get the next root from preorder
        int rootValue = preorder[preorderIndex++];

        TreeNode root = new TreeNode(rootValue);

        // Find root position in inorder
        int mid = inorderMap.get(rootValue);

        // Construct left subtree
        root.left = buildTree(
            preorder,
            left,
            mid - 1
        );

        // Construct right subtree
        root.right = buildTree(
            preorder,
            mid + 1,
            right
        );

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

        int[] preorder = new int[n];
        int[] inorder = new int[n];

        // Read preorder traversal
        for (int i = 0; i < n; i++) {
            preorder[i] = sc.nextInt();
        }

        // Read inorder traversal
        for (int i = 0; i < n; i++) {
            inorder[i] = sc.nextInt();
        }

        // Store inorder positions for fast lookup
        inorderMap = new HashMap<>();

        for (int i = 0; i < n; i++) {
            inorderMap.put(inorder[i], i);
        }

        preorderIndex = 0;

        // Construct binary tree
        TreeNode root = buildTree(
            preorder,
            0,
            n - 1
        );

        System.out.println(levelOrder(root));

        sc.close();
    }
}