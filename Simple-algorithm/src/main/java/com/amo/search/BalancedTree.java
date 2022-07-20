package com.amo.search;

/**
 * 输入一棵二叉树的根节点，判断该树是不是平衡二叉树。
 * 如果某二叉树中任意节点的左右子树的深度相差不超过1，那么它就是一棵平衡二叉树。
 */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        //空树算平衡二叉树
        if (root==null) return true;
        //判断整个树还有左子树以及右子树是否都满足平衡条件
        return Math.abs(depth(root.left)-depth(root.right))<=1&&isBalanced(root.left)&&isBalanced(root.right);
    }

    //查找左右子树高度
    int depth(TreeNode node){
        if (node==null) return 0;
        return Math.max(depth(node.left),depth( node.right))+1;
    }
}
