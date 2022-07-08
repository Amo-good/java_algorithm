package com.amo.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 从上到下打印二叉树
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 * 例如:
 * 给定二叉树: [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 输出: [3,9,20,15,7]
 */
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}
class Solution {
    //层次遍历
    public int[] levelOrder(TreeNode root) {
        if (root==null)return new int[0];
        //初始化队列
        Queue<TreeNode> queue=new LinkedList<>();
        //保存数据
        ArrayList<Integer> arrayList=new ArrayList<>();
        //根节点入队列
        queue.add(root);
        while (!queue.isEmpty()){
            //队头节点出队
            TreeNode node = queue.remove();
            //保存元素
            arrayList.add(node.val);
            if (node.left!=null){
                //左子树不为空
                queue.add(node.left);
            }
            if (node.right!=null){
                //右子树不为空
                queue.add(node.right);
            }
        }
        int []a=new int[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            a[i]= arrayList.get(i);
        }
        return a;
    }


}