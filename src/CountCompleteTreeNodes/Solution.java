package CountCompleteTreeNodes;

/**
 * Created by liutaotao on 2018/3/27.
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
    public int primeCountNodes(TreeNode root) {
        if (root == null) return 0;
        return 1 + primeCountNodes(root.left) + primeCountNodes(root.right);
    }

    //    public int countNodes(TreeNode root) {
//        if (root == null) return 0;
//        return 1 + countNodes(root.left) + countNodes(root.right);
//    }
//
//    static TreeNode insert(int[] nums, int left, int right) {
//        if (left > right) return null;
//        int mid = (left + right) / 2;
//        TreeNode root = new TreeNode(nums[mid]);
//        root.left = insert(nums, left, mid - 1);
//        root.right = insert(nums, mid + 1, right);
//        return root;
//    }

    static int level(TreeNode root) {
        return root == null ? 0 : 1 + level(root.left);
    }


    /**
     *      1
     *   2     3
     * 4   5
     */
    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = level(root.left);
        int rightHeight = level(root.right);
        if (leftHeight == rightHeight) return (1 << leftHeight)  + countNodes(root.right);
        else return (1 << rightHeight) + countNodes(root.left);
    }

    public static void main(String[] args) {

//        TreeNode root = insert(nums, 0, nums.length - 1);
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left= new TreeNode(8);
        Solution solution = new Solution();
        System.out.println(solution.countNodes(root));
        System.out.println(solution.primeCountNodes(root));
//        System.out.println(solution.countleft(root));
    }
}
