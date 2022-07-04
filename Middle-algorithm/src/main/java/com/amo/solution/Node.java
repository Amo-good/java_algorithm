package com.amo.solution;

import java.util.HashMap;

/**
 * 请实现 copyRandomList 函数，复制一个复杂链表。
 * 在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
class Solution {
    public Node copyRandomList(Node head) {
        if (head==null) return null;
        //保存当前节点
        Node cur=head;
        //用hashmap来保存各节点
        HashMap<Node,Node> nodeMap=new HashMap<>();
        while (cur!=null){
            //保存各个节点的值
            nodeMap.put(cur,new Node(cur.val));
            //指向下一个节点
            cur=cur.next;
        }
        //重新遍历，保存next和random
        cur=head;
        while (cur!=null){
            //保存next
            Node node = nodeMap.get(cur);
            node.next=nodeMap.get(cur.next);
            //保存random
            node.random=nodeMap.get(cur.random);
            //指向下一个
            cur=cur.next;
        }
        //返回map中第一个元素即可
        return nodeMap.get(head);
    }
}