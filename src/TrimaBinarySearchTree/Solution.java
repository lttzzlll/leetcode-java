package TrimaBinarySearchTree;

/**
 * Created by liutaotao on 2018/5/30.
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
    void previsit(TreeNode node) {
        if (node != null) {
            previsit(node.left);
            System.out.println(node.val);
            previsit(node.right);
        }
    }

    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return null;
        if (root.val < L) return trimBST(root.right, L, R);
        if (root.val > R) return trimBST(root.left, L, R);
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(0);
        root.right = new TreeNode(4);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(1);

        Solution solution = new Solution();
        TreeNode node = solution.trimBST(root, 1, 3);
        solution.previsit(node);
    }

}
