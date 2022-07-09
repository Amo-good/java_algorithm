package com.amo.search;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 */
public class SubStructure {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        //树为空直接返回
        if (A==null||B==null) return false;
        //从根节点比较，遍历每个左子树的点比较和遍历每个右子树的点比较
        return recur(A,B)||isSubStructure(A.left, B)||isSubStructure(A.right, B);
    }
    //判断每个节点是否一样
    boolean recur(TreeNode A,TreeNode B){
        //当节点B为空：说明树B已匹配完成（越过叶子节点），因此返回 true;
        if (B==null) return true;
        //当节点A为空：说明已经越过树 A 叶子节点，即匹配失败，或者A和B节点的值不同，返回 false;
        if (A==null||A.val!=B.val) return false;
        return recur(A.left,B.left) && recur(A.right, B.right);
    }
}
