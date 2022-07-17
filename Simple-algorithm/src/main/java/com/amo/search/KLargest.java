package com.amo.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 */
public class KLargest {
    int res,k;
    public int kthLargest(TreeNode root, int k) {
        //k需要是全局变量
        this.k=k;
        dfs(root);
        return res;
    }
    //利用中序遍历的倒序得出来的数组就是从大到小
    void dfs(TreeNode node){
        if (node==null) return;
        dfs(node.right);
        if (k==0) return;//（记录最大值后，因为迭代原因，左子树第一个k也会为0）
        //k=0，代表当前节点为最大节点，记录值
        if (--k==0) res= node.val;
        dfs(node.left);
    }




/*    List<Integer> list=new ArrayList<>();
    public int kthLargest(TreeNode root, int k) {
        topK(root);
        return list.get(list.size()-k);
    }
    //二叉树，用中序遍历
    void topK(TreeNode node){
        if (node==null) return;
        topK(node.left);
        list.add(node.val);
        topK(node.right);
    }*/
}
