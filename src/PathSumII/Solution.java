package PathSumII;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

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

    //    void visit(List<List<Integer>> list, List<Integer> curList, TreeNode root, int sum) {
//        if (root == null) return;
//        if (root.left == null && root.right == null) {
//            if (root.val == sum) {
//                curList.add(root.val);
//                list.add(curList);
//            } else curList.clear();
//            return;
//        }
//        curList.add(root.val);
//        if (root.left != null) visit(list, curList.stream().collect(Collectors.toList()), root.left, sum - root.val);
//        if (root.right != null) visit(list, curList.stream().collect(Collectors.toList()), root.right, sum - root.val);
//    }
    void visit(List<List<Integer>> list, List<Integer> curList, TreeNode root, int sum) {
        if (root == null) return;
        curList.add(root.val);
        if (root.val == sum && root.left == null && root.right == null) {
            list.add(curList.stream().collect(Collectors.toList()));
            curList.remove(curList.size() - 1);
            return;
        } else {
            visit(list, curList, root.left, sum - root.val);
            visit(list, curList, root.right, sum - root.val);
        }
        curList.remove(curList.size() - 1);
    }


    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> list = new LinkedList<>();
        visit(list, new ArrayList<>(), root, sum);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(5);
        root.right.right.right = new TreeNode(1);
        Solution solution = new Solution();
        List<List<Integer>> list = solution.pathSum(root, 22);
        for (List<Integer> item : list) {
            for (Integer i : item) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}

