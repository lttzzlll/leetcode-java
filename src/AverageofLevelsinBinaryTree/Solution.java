package AverageofLevelsinBinaryTree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
//    void visit(List<List<Integer>> list, TreeNode root, int level) {
//        if (root == null) return;
//        if (level + 1 > list.size()) list.add(new LinkedList<>());
//        list.get(level).add(root.val);
//        visit(list, root.left, level + 1);
//        visit(list, root.right, level + 1);
//    }
//
//    public List<Double> averageOfLevels(TreeNode root) {
//        List<Double> list = new LinkedList<>();
//        if (list != null) {
//            List<List<Integer>> res = new LinkedList<>();
//            visit(res, root, 0);
//            for (int i = 0; i < res.size(); i++) {
//                double sum = 0;
//                for (int j = 0; j < res.get(i).size(); j++) {
//                    sum += res.get(i).get(j);
//                }
//                list.add(sum / res.get(i).size());
//            }
//        }
//        return list;
//    }


    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> list = new LinkedList<>();
        if (root != null) {
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while (!queue.isEmpty()) {
                int levelCount = queue.size();
                double sum = 0.0;
                for (int i = 0; i < levelCount; i++) {
                    TreeNode node = queue.poll();
                    sum += node.val;
                    if (node.left != null) queue.offer(node.left);
                    if (node.right != null) queue.offer(node.right);
                }
                list.add(sum / levelCount);
            }
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        Solution solution = new Solution();
        List<Double> res = solution.averageOfLevels(root);
        for (Double d : res) {
            System.out.println(d);
        }
    }
}
