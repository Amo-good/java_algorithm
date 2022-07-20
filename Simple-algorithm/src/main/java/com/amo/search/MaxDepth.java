package com.amo.search;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 输入一棵二叉树的根节点，求该树的深度。
 * 从根节点到叶节点依次经过的节点（含根、叶节点）形成树的一条路径，最长路径的长度为树的深度。
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * 深度为3
 */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root==null) return 0;
        //采用层次遍历
        Queue<TreeNode> queue=new LinkedList<>();
        //记录深度
        int depth=0;
        queue.add(root);
        while (!queue.isEmpty()){
            for (int i = queue.size(); i >0; i--) {
                TreeNode poll = queue.poll();
                if (poll.left!=null) queue.add(poll.left);
                if (poll.right!=null) queue.add(poll.right);
            }
            //每层打印完，深度加1
            depth++;
        }
        return depth;
    }
    // 此树的深度和其左（右）子树的深度之间的关系。显然，此树的深度等于左子树的深度与右子树的深度中的最大值 +1+1 。
/*    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/
}
