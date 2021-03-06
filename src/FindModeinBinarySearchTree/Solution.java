package FindModeinBinarySearchTree;

/**
 * Created by liutaotao on 2017/12/17.
 */

import java.util.ArrayList;
import java.util.List;

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
    Integer preVal = null;
    int count = 1;
    int maxCount = 0;


    private void traverse(TreeNode root, List<Integer> list) {
        if (root == null) return;
        traverse(root.left, list);
        if (preVal != null) {
            if (root.val == preVal) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > maxCount) {
            maxCount = count;
            list.clear();
            list.add(root.val);
        } else if (count == maxCount) {
            list.add(root.val);
        }
        preVal = root.val;
        traverse(root.right, list);
    }

    public int[] findMode(TreeNode root) {
        if (root == null) return new int[0];
        List<Integer> list = new ArrayList<>();
        traverse(root, list);
        return list.stream().mapToInt(Integer::intValue).toArray();
    }


    private void tranverse(int[] nums, List<Integer> list) {
        Integer preVal = null;
        int count = 1;
        int maxCount = 0;
        for (int i : nums) {
            if (preVal != null) {
                if (i == preVal) {
                    count++;
                } else {
                    count = 1;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                list.clear();
                list.add(i);
            } else if (count == maxCount) {
                list.add(i);
            }
            preVal = i;
        }
    }

    public int[] findMode(int[] nums) {
        if (nums == null || nums.length == 0) return new int[0];
        List<Integer> list = new ArrayList<>();
        return list.stream().mapToInt(Integer::intValue).toArray();
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
