package TwoSumIVInputisaBST;

import java.util.HashSet;

/**
 * Created by liutaotao on 2018/4/18.
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

    HashSet<Integer> set = new HashSet<>();

    boolean dfs(TreeNode root, int k) {
        if (root == null) return false;
        if (set.contains(k - root.val)) return true;
        set.add(root.val);
        return dfs(root.left, k) || dfs(root.right, k);
    }

    public boolean findTarget(TreeNode root, int k) {
        return dfs(root, k);
    }

    public static void main(String[] args) {
//        TreeNode root = new TreeNode(5);
//        root.left = new TreeNode(3);
//        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(4);
//        root.right = new TreeNode(6);
//        root.right.right = new TreeNode(7);
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        System.out.println(solution.findTarget(root, 4));
    }
}
