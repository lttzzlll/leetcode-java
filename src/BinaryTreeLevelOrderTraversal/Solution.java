package BinaryTreeLevelOrderTraversal;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/3/26.
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
    void visit(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level + 1 > list.size()) list.add(new LinkedList<>());
        list.get(level).add(root.val);
        visit(list, root.left, level + 1);
        visit(list, root.right, level + 1);
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<>();
        if (root != null)
            visit(res, root, 0);

        return res;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        List<List<Integer>> list = solution.levelOrder(root);
        for (List<Integer> cell : list) {
            for (Integer i : cell) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
