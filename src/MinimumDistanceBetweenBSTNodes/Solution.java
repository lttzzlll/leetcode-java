package MinimumDistanceBetweenBSTNodes;

/**
 * Created by liutaotao on 2018/6/25.
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
    boolean isLeafNode(TreeNode node) {
        return node.left == null && node.right == null;
    }

    int search(TreeNode root, int parentVal) {
        if (isLeafNode(root)) return Math.abs(root.val - parentVal);
        if (root.left == null) return search(root.right, root.val);
        else if (root.right == null) return search(root.left, root.val);
        else return Math.min(search(root.left, root.val), search(root.right, root.val));
    }

    public int minDiffInBST(TreeNode root) {
        return search(root, Integer.MAX_VALUE);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(4);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(6);
//        root.left.left = new TreeNode(1);
//        root.left.right = new TreeNode(3);
//        TreeNode root = new TreeNode(27);
//        root.right = new TreeNode(34);
//        root.right.right = new TreeNode(58);
//        root.right.right.left = new TreeNode(50);
//        root.right.right.left.left = new TreeNode(44);

        TreeNode root = new TreeNode(96);
        root.left = new TreeNode(12);
        root.left.right = new TreeNode(13);
        root.left.right.right = new TreeNode(52);
        root.left.right.right.left = new TreeNode(29);
        Solution solution = new Solution();
        System.out.println(solution.minDiffInBST(root));
    }
}
