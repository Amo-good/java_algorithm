package com.amo.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 给你二叉树的根节点 root 和一个整数目标和 targetSum ，找出所有 从根节点到叶子节点 路径总和等于给定目标和的路径。
 * 叶子节点 是指没有子节点的节点。
 * 输入：root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22
 * 输出：[[5,4,11,2],[5,8,4,5]]
 *
 */
public class PathSum {
    LinkedList<List<Integer>> res=new LinkedList<>();
    LinkedList<Integer> path=new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        //找出所有从根节点到叶子节点，考虑用先序遍历
        recur(root, target);
        return res;
    }
    void recur(TreeNode root,int tar){
        if (root==null) return;
        //添加路径
        path.add(root.val);
        tar-= root.val;
        if (tar==0&&root.left==null&&root.right==null){
            //必须是叶子节点并且，tar为0，才算找到目标路径
            res.add(new LinkedList<>(path));//这里需要新建一个path链，否则后面path变化会影响其变化
        }
        recur(root.left, tar);
        recur(root.right, tar);
        //当走到这一步的时候，已经为叶子节点，并且tar不等于0，因此我们移除最后一个元素并返回
        path.removeLast();
    }

}
