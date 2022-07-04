package com.amo.solution;

import java.util.Stack;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 */
public class ReverseList {
    public ListNode reverseList(ListNode head) {
        //头插法
        ListNode pre=null,next=null;
        while (head!=null){
            //保存下一个节点
            next=head.next;
            //指向前一个节点 如果是1->null 如果是2->1 如果是3->2->1
            head.next=pre;
            //保存当前节点
            pre=head;
            //遍历下一个节点
            head=next;
        }
        return pre;

     /*
        递归实现
        if(head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return node;*/
    }
}
