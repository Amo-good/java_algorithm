package com.amo.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下按层打印二叉树，同一层的节点按从左到右的顺序打印，每一层打印到一行。
 *    3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出:
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root==null) return new ArrayList<>();
        Queue<TreeNode> queue=new LinkedList<>();
        List<List<Integer>> list=new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            //用来临时存储同一层的节点值
            List<Integer> tmp=new ArrayList<>();
            for (int i=queue.size();i> 0;i--){
                TreeNode node = queue.poll();
                tmp.add(node.val);
                if (node.left!=null){
                    queue.add(node.left);
                }
                if (node.right!=null){
                    queue.add(node.right);
                }
            }
            list.add(tmp);
        }
        return list;
    }
}