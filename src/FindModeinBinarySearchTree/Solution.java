package FindModeinBinarySearchTree;

/**
 * Created by liutaotao on 2017/12/17.
 */

import java.util.*;

/**
 * Definition for a binary tree node.
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
    HashMap<Integer, Integer> set = new HashMap<>();

    private void inorder(TreeNode root, int val) {
        if (root == null) return;
        inorder(root.left, val);
        if (root.val == val) set.put(val, set.getOrDefault(val, 0) + 1);
        else set.put(root.val, 0);
        inorder(root.right, val);
    }


    // 这道题应该是一边遍历节点,一边计算,而不是分开,分开就没有同步的过程了.
    public int[] findMode(TreeNode root) {
        inorder(root, root.val);
        List<Integer> counts = new ArrayList<Integer>(set.values());
        Collections.sort(counts, (o1, o2) -> o2 - o1);
        List<Integer> res = new ArrayList<>();
        int maxCount = counts.get(0);
        Iterator iter = set.entrySet().iterator();
        while (iter.hasNext()) {
            Map.Entry<Integer, Integer> pair = (Map.Entry<Integer, Integer>) iter.next();
            if (pair.getValue() == maxCount) res.add(pair.getKey());
        }
        int[] arr = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            arr[i] = res.get(i);
        }
        return arr;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.right = new TreeNode(2);
        root.right.left = new TreeNode(2);
        Solution solution = new Solution();
        int[] arr = solution.findMode(root);
        for (int i : arr) {
            System.out.printf("%4d", i);
        }
        System.out.println();
    }
}
