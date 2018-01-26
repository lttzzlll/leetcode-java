package BinarySearchTreeIterator;

import java.util.Stack;

/**
 * Created by liutaotao on 2018/1/17.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

public class BSTIterator {
    Stack<TreeNode> stack;
    TreeNode node;

    public BSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }


    public int next() {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
        node = stack.pop();
        int val = node.val;
        node = node.right;
        return val;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right = new TreeNode(15);
        root.right.right = new TreeNode(18);


        BSTIterator i = new BSTIterator(root);
        while (i.hasNext()) {
            System.out.println(i.next());
        }
    }
}
