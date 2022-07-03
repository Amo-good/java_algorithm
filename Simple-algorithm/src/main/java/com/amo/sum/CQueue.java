package com.amo.sum;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，
 * 分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead操作返回 -1 )
 *
 */
public class CQueue {
    //两个栈，stack1入栈，stack2出栈
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    //队列先进先出
    public CQueue() {
        stack1=new Stack<>();
        stack2=new Stack<>();
    }

    public void appendTail(int value) {
        //stack1入栈
        stack1.push(value);
    }

    public int deleteHead() {
        //如果stack1和stack2都为空，则返回-1
        if (stack1.isEmpty()&&stack2.isEmpty()){
            return -1;
        }
        //如果stack2为空，则初始化stack2
        if (stack2.isEmpty()){
            while (!stack1.isEmpty()){
                //相当于交换了stack1中的数据
                stack2.push(stack1.pop());
            }
        }
        return stack2.pop();
    }
}
