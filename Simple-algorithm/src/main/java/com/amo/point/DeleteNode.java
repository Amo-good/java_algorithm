package com.amo.point;


import java.util.Stack;

/**
 * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
 * 返回删除后的链表的头节点。
 * 注意:题目保证链表中节点的值互不相同
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class DeleteNode {
    public ListNode deleteNode(ListNode head, int val) {
        //如果删除的节点为头节点，则直接返回头节点的下一个节点
        if (head.val==val) return head.next;
       //保存当前节点和前驱节点
        ListNode pre=head,cur=head.next;
        while (cur!=null){
            if (cur.val==val){
                //当前节点为目标节点，则使前驱节点指向目标节点的下一个节点
                pre.next=cur.next;
                //退出循环
                break;
            }
            pre=cur;
            cur=cur.next;
        }

        return head;
    }
}
