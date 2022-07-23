package com.amo.divide;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。
 * 如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return recur(postorder, 0, postorder.length - 1);
    }

    private boolean recur(int[] postorder, int i, int j) {
        //子树节点数量<=1，返回true
        if(i>=j)  return true;
        int p=i;
        //后序遍历中，postorder[j]为根节点，查找左子树的长度
        while (postorder[p]<postorder[j]) p++;
        int m=p;//记录右子树开始节点
        //查找右子树长度
        while (postorder[p]>postorder[j]) p++;
        //判断p能否正常走到数组末尾  判断左右子树是否满足后序遍历规则
        return p==j&&recur(postorder, i,m-1)&&recur(postorder, m, j-1);
    }
}
