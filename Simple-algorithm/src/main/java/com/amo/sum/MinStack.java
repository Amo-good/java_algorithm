package com.amo.sum;

import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈的最小元素的 min 函数在该栈中，
 * 调用 min、push 及 pop 的时间复杂度都是 O(1)。
 */
public class MinStack {
    //定义两个栈，stack1用来保存栈信息，stack2用来保存最小值
    private final Stack<Integer> stack1;
    private final Stack<Integer> stack2;
    public MinStack() {
        //初始化栈
        stack1=new Stack<>();
        stack2=new Stack<>();
        //初始时，在stack2中放入最大值
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int x) {
      stack1.push(x);
      if (stack1.peek()<=stack2.peek()){
          //如果新入栈的元素小于最小栈中保存的元素，则将最小元素压入栈
          stack2.push(x);
      }
    }


    public void pop() {
        //如果最小元素被弹出栈了，那么stack2也要及时更新
        if (stack1.peek().equals(stack2.peek())){
            stack2.pop();
        }
        stack1.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int min() {
        return stack2.peek();
    }
}
