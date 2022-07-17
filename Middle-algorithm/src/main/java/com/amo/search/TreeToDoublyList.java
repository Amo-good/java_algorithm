package com.amo.search;

/**
 * 输入一棵二叉搜索树，将该二叉搜索树转换成一个排序的循环双向链表。
 * 要求不能创建任何新的节点，只能调整树中节点指针的指向。
 */
public class TreeToDoublyList {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) return null;
        dfs(root);
        //递归结束时head为第一个节点
        head.left = pre;
        //pre为最后一个节点
        pre.right = head;
        return head;
    }
    //因为采用排序，因此需要用中序
    void dfs(Node cur) {
        if(cur == null) return;
        //一直遍历左节点
        dfs(cur.left);
        //上一个节点指向下一个节点
        if(pre != null) pre.right = cur;
        else head = cur;//保存第一个节点（也就是最小的节点）
        //最节点指向上一个节点
        cur.left = pre;
        //保存当前节点
        pre = cur;
        //遍历右子树
        dfs(cur.right);
    }
}
