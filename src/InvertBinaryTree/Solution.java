package InvertBinaryTree;

/**
 * Created by liutaotao on 2018/4/12.
 */
class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

public class Solution {
    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = invertTree(root.left);
            TreeNode right = invertTree(root.right);
            root.right = left;
            root.left = right;
        }
        return root;
    }

    static void preorder(TreeNode root) {
        if (root != null) {
            System.out.println(root.val);
            preorder(root.left);
            preorder(root.right);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.right = new TreeNode(7);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(9);
        Solution solution = new Solution();
        TreeNode node = solution.invertTree(root);
        preorder(node);
    }
}
