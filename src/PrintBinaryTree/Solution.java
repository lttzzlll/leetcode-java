package PrintBinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by liutaotao on 2018/5/28.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}

class LevelNode {
    TreeNode treeNode;
    int level;
    int low;
    int high;

    LevelNode(TreeNode treeNode, int level, int low, int high) {
        this.treeNode = treeNode;
        this.level = level;
        this.low = low;
        this.high = high;
    }
}

public class Solution {
    int getLevel(TreeNode root) {
        if (root == null) return 0;
        if (root.left == null && root.right == null) return 1;
        return 1 + Math.max(getLevel(root.left), getLevel(root.right));
    }

    public List<List<String>> printTree(TreeNode root) {
        if (root == null) return new LinkedList<>();

        int height = getLevel(root);
        int width = (int) Math.pow(2, height) - 1;

        List<List<String>> container = new ArrayList<>(height);

        for (int i = 0; i < height; i++) {
            List<String> list = new ArrayList<>(width);
            for (int j = 0; j < width; j++) {
                list.add("");
            }
            container.add(list);
        }

        Queue<LevelNode> que = new LinkedList<>();

        que.add(new LevelNode(root, 1, 0, width));

        while (!que.isEmpty()) {
            LevelNode node = que.poll();
            int pos = (node.low + node.high) / 2;
            container.get(node.level - 1).set(pos, String.valueOf(node.treeNode.val));
            if (node.treeNode.left != null) {
                que.add(new LevelNode(node.treeNode.left, node.level + 1, node.low, pos));
            }
            if (node.treeNode.right != null) {
                que.add(new LevelNode(node.treeNode.right, node.level + 1, pos, node.high));
            }
        }
        return container;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.left.left = new TreeNode(4);

        Solution solution = new Solution();
        List<List<String>> list = solution.printTree(root);
        for (List<String> row : list) {
            for (String col : row) {
                System.out.print(col);
            }
            System.out.println();
        }
    }
}
