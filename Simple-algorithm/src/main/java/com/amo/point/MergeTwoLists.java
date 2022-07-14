package com.amo.point;

/**
 * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
 * 输入：1->2->4, 1->3->4
 * 输出：1->1->2->3->4->4
 */
public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //设置一个伪头节点，用来合并两个链表
        ListNode dum=new ListNode(0),cur=dum;
        while (l1!=null&&l2!=null){
            //交替前进
            if (l1.val>=l2.val){
                cur.next=l2;
                l2=l2.next;
            }else {
                cur.next=l1;
                l1=l1.next;
            }
            cur=cur.next;
        }
        //当循环结束，我们还需要遍历剩余的节点
        cur.next=(l1!=null)?l1:l2;
        //伪头节点的下一个节点即为我们合并的链表
        return dum.next;
    }
}
