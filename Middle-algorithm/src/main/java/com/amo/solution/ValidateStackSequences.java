package com.amo.solution;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。
 * 假设压入栈的所有数字均不相等。
 * 例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 *
 */
public class ValidateStackSequences {
    //借用一个辅助栈stack ，模拟 压入 / 弹出操作的排列
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack=new Stack<>();
        //按顺序入栈
        int i=0;
        for (int e : pushed) {
            stack.push(e);//入栈
            while (!stack.isEmpty()&&stack.peek()==popped[i]){
                stack.pop();//出栈
                i++;
            }
        }
        return stack.isEmpty();


    }
}
