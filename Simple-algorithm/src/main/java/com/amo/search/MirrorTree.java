package com.amo.search;


import java.util.Stack;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 * 镜像输出树的结构
 */
public class MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
    //利用层次遍历和栈实现
        if (root==null) return null;
        Stack<TreeNode> stack=new Stack<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode pop = stack.pop();
            if (pop.left!=null){
                stack.push(pop.left);
            }
            if (pop.right!=null){
                stack.push(pop.right);
            }
            //保存左节点
            TreeNode tmp=pop.left;
            pop.left=pop.right;
            pop.right=tmp;
        }
        return root;
    }

    //利用递归遍历
   /* public TreeNode mirrorTree(TreeNode root) {
        if(root == null) return null;
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;
    }*/


}
