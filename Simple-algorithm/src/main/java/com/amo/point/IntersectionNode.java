package com.amo.point;

import java.util.HashSet;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 * 如果两个链表没有交点，返回 null.
 * 在返回结果后，两个链表仍须保持原有的结构。
 */
public class IntersectionNode {
    //用哈希
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        HashSet<ListNode> visited=new HashSet<>();
        ListNode A=headA,B=headB;
        while (A!=null){
            //先将A的节点放入
            visited.add(A);
            A=A.next;
        }
        while(B!=null){
            //如果B的节点中包含A的，那这相同的就是共同节点
            if (visited.contains(B)) return B;
            B=B.next;
        }
        //如果没重复，返回null
        return null;
    }

    //双指针法
/*    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode A=headA,B=headB;
        //指针A走完走B，B走完走A，当他们相遇时，结果为null（没有公共节点）或者公共节点
        while(A!=B){
            A=A!=null?A.next:headB;
            B=B!=null?B.next:headA;
        }

        return A;
    }*/
}
