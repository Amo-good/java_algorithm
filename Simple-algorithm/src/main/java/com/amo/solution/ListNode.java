package com.amo.solution;

import java.util.Stack;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回)
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
class Solution {
    public int[] reversePrint(ListNode head) {
       int length=0;//记录数组长度
        Stack<Integer> stack=new Stack<>();
        while (head != null) {
            stack.push(head.val);
            head = head.next;//指向下一个指针
            length++;
        }
        int i = 0;
        int []arr=new int[length];
        while (!stack.empty()){
            arr[i++]=stack.pop();
        }
        return arr;
    }
}
