package com.amo.search;

/**
 * 注意，此题给的是二叉树！！！！
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x,
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 *
 */
public class LowestCommonAncestorII {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //当遇到节点 p或 q时返回
        if(root == null || root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        //左子树为空，说明公共祖先在右子树
        if(left == null) return right;
        //如果右子树为空，说明公共祖先在左子树
        if(right == null) return left;
        //当左右都不为空，说明最近公共祖先为根节点
        return root;
    }
}
