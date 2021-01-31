package cn.clown;

/**
 * 计算二叉树深度
 *
 * @author clown
 */
public class Solution {
    public static void main(String[] args) {
        TreeNode p = new TreeNode(1);
        p.left = new TreeNode(2);
        p.right = new TreeNode(3);
        p.left.left = null;
        p.left.right = null;
        p.right.left = new TreeNode(4);
        p.right.right = new TreeNode(5);
        Solution t = new Solution();
        System.out.println(t.maxDepth(p));
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int nleft = maxDepth(root.left);
        int nright = maxDepth(root.right);
        return nleft > nright ? nleft + 1 : nright + 1;
    }
}

class TreeNode {
    int data;
    TreeNode left;
    TreeNode right;

    TreeNode(int val) {
        data = val;
    }
}