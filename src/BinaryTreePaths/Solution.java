package BinaryTreePaths;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by liutaotao on 2018/3/30.
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
//    void visit(List<String> list, LinkedList<String> buf, TreeNode root) {
//        if (root == null) return;
//        if (root.left == null && root.right == null) {
//            buf.add(String.valueOf(root.val));
//            String str = buf.toString();
//            list.add(str.substring(1, str.length() - 1).replaceAll(", ", ""));
//            buf.remove(buf.size() - 1);
//        } else {
//            buf.add(String.valueOf(root.val) + "->");
//            visit(list, buf, root.left);
//            visit(list, buf, root.right);
//            buf.remove(buf.size() - 1);
//        }
//    }
//
//    public List<String> binaryTreePaths(TreeNode root) {
//        List<String> list = new LinkedList<>();
//        visit(list, new LinkedList<String>(), root);
//        return list;
//    }

    void visit(List<String> list, String path, TreeNode root) {
        if (root == null) return;
        if (root.left == null && root.right == null) list.add(path + root.val);
        if (root.left != null) visit(list, path + root.val + "->", root.left);
        if (root.right != null) visit(list, path + root.val + "->", root.right);
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> list = new LinkedList<>();
        visit(list, "", root);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right = new TreeNode(3);
        Solution solution = new Solution();
        List<String> res = solution.binaryTreePaths(root);
        for (String s : res) {
            System.out.println(s);
        }
    }
}
