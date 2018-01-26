package BinaryTreeVisitStack;

import java.util.Stack;

/**
 * Created by liutaotao on 2018/1/22.
 */

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    public TreeNode(int x) {
        val = x;
    }
}

interface BSTIterator {
    int next();

    boolean hasNext();
}

class PreOrderBSTIterator implements BSTIterator {
    Stack<TreeNode> stack;
    TreeNode node;

    public PreOrderBSTIterator(TreeNode root) {
        stack = new Stack<>();
        node = root;
    }

    @Override
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

    @Override
    public boolean hasNext() {
        return !stack.isEmpty() || node != null;
    }
}

class InOrderBSTIterator implements BSTIterator {
    Stack<TreeNode> stack;

    public InOrderBSTIterator(TreeNode root) {
        stack = new Stack<>();
        if (root != null)
            stack.push(root);
    }

    /**
     * 10
     * -  -
     * -    -
     * -      -
     * 5        15
     * --        --
     * -  -      -  -
     * -    -    -    -
     * -      -  -      -
     * 1       8 12      20
     */

    @Override
    public int next() {
        TreeNode node = stack.pop();
        int val = node.val;
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
        return val;
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }
}

class PostOrderBSTIterator implements BSTIterator {
    Stack<TreeNode> s1;
    Stack<TreeNode> s2;


    public PostOrderBSTIterator(TreeNode root) {
        s1 = new Stack<>();
        s2 = new Stack<>();
        if (root != null) s1.push(root);
        while (!s1.isEmpty()) {
            TreeNode node = s1.pop();
            s2.push(node);
            if (node.left != null) s1.push(node.left);
            if (node.right != null) s1.push(node.right);
        }
    }

    /**
     *                 12
     *                -  -
     *               -    -
     *              -      -
     *             5        15
     *            --        --
     *           -  -      -  -
     *          -    -    -    -
     *         -      -  -      -
     *        1       8 13      20
     *                -
     *                 -
     *                  -
     *                  10
     *                  --
     *                 -  -
     *                -    -
     *               -      -
     *              9        11
     */
    @Override
    public int next() {
        return s2.pop().val;
    }

    @Override
    public boolean hasNext() {
        return !s2.isEmpty();
    }
}


public class Solution {
    public static void main(String[] args) {
        /**
         *              5
         *             - -
         *            -   -
         *           -     -
         *          -       -
         *         3        15
         *          -       - -
         *           -     -   -
         *            4   10   20
         *
         *
         */
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(8);
        root.left.right.right = new TreeNode(10);
        root.left.right.right.left = new TreeNode(9);
        root.left.right.right.right = new TreeNode(11);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(20);


//        preOrderVisit(root);
//        inOrderVisit(root);
        postOrderVisit(root);
    }

    static void postOrderVisit(TreeNode root) {
        PostOrderBSTIterator it = new PostOrderBSTIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("-----------------------------");
    }

    static void inOrderVisit(TreeNode root) {
        InOrderBSTIterator it = new InOrderBSTIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("---------------------------");
    }

    static void preOrderVisit(TreeNode root) {
        PreOrderBSTIterator it = new PreOrderBSTIterator(root);
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("------------------");
    }
}
