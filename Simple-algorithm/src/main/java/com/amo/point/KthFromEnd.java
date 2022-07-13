package com.amo.point;

import java.util.Stack;

/**
 * 输入一个链表，输出该链表中倒数第k个节点。
 * 为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
 * 例如，一个链表有 6 个节点，从头节点开始，它们的值依次是 1、2、3、4、5、6。这个链表的倒数第 3 个节点是值为 4 的节点。
 * 给定一个链表: 1->2->3->4->5, 和 k = 2.
 * 返回链表 4->5.
 */
public class KthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        //使用快慢指针 前指针 former 先向前走 k 步（结束后，双指针 former 和 latter 间相距 k 步）。
        //初始化
        ListNode former=head,latter=head;
        //快指针要先走k步
        for (int i = 0; i <k; i++) {
            if(former == null) return null;
            former=former.next;
        }
        //当快指针走到终点时，此时慢指针所指向的刚好是倒数第k节点
        while (former!=null){
            former=former.next;
            latter=latter.next;
        }
        return latter;
    }
    /*
        使用栈实现
        public ListNode getKthFromEnd(ListNode head, int k) {
        //保存元素
        Stack<ListNode> stack=new Stack<>();
        stack.push(head);
        while (head.next!=null){
            head=head.next;
            stack.push(head);
        }
        for (int i = 1; i <k; i++) {
            stack.pop();
        }
        return stack.peek();
    }*/
}
