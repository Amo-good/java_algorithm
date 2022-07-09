package com.amo.search;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        //注意:空的树也算对称树
        if (root==null) return true;
        return isSame(root.left, root.right);
    }
    //判断左右子树是否相同
    boolean isSame(TreeNode left,TreeNode right){
        //同时为空，遍历完成，树对称
        if (left==null&&right==null) return true;
        //只能两个节点同时会空，否则不对称
        if (left==null||right==null) return false;
        //值不相同时不对称
        if (left.val!=right.val) return false;
        return isSame(left.left ,right.right)&&isSame(left.right, right.left);
    }
}
