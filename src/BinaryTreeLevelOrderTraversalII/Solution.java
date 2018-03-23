package BinaryTreeLevelOrderTraversalII;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/3/22.
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
//    int maxLevel = 0;
//
//    class Record {
//        int level;
//        TreeNode node;
//
//        public Record(TreeNode node, int level) {
//            this.node = node;
//            this.level = level;
//        }
//    }
//
//    void visit(List<Record> list, TreeNode root, int level) {
//        if (root != null) {
//            Record record = new Record(root, level);
//            list.add(record);
//            visit(list, root.left, level + 1);
//            visit(list, root.right, level + 1);
//            if (level + 1 > maxLevel) maxLevel = level + 1;
//        }
//    }
//
//    public List<List<Integer>> levelOrderBottom(TreeNode root) {
//        if (root == null) return new ArrayList<>(0);
//        List<Record> records = new ArrayList<>();
//        visit(records, root, 0);
//        List<List<Integer>> list = new ArrayList<>(records.get(records.size() - 1).level + 1);
//        for (int i = 0; i < maxLevel; i++) {
//            list.add(new LinkedList<>());
//        }
//        for (Record record : records) {
//            System.out.println(record.level);
//            list.get(maxLevel - record.level - 1).add(record.node.val);
//        }
//
//        return list;
//    }

    void visit(List<List<Integer>> list, TreeNode root, int level) {
        if (root == null) return;
        if (level + 1 > list.size()) list.add(0, new LinkedList<>());
        visit(list, root.left, level + 1);
        visit(list, root.right, level + 1);
        list.get(list.size() - level - 1).add(root.val);
    }

    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> list = new LinkedList<List<Integer>>();
        visit(list, root, 0);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
//        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(2);
//        root.right = new TreeNode(3);
//        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        TreeNode root = null;
        Solution so = new Solution();
        List<List<Integer>> list = so.levelOrderBottom(root);
        for (List<Integer> curlist : list) {
            for (Integer i : curlist) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
