package com.amo.solution;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 *
 * 若队列为空，pop_front 和 max_value需要返回 -1
 *
 */
public class MaxQueue {
    Deque<Integer> deque;
    Deque<Integer> maxDeque;
    public MaxQueue() {
        deque=new LinkedList<>();
        maxDeque=new LinkedList<>();
    }

    public int max_value() {
        if (deque.isEmpty()) return -1;
        return maxDeque.peekFirst();
    }

    public void push_back(int value) {
        //添加进队尾
        deque.addLast(value);
        //删除所有小于当前值的队列元素
        while (!maxDeque.isEmpty()&&maxDeque.peekLast()<value) maxDeque.pollLast();
        //添加元素
        maxDeque.addLast(value);
    }

    public int pop_front() {
        if (deque.isEmpty()) return -1;
        //判断当前出队的元素是否为最大值，是的话要及时更新最大值
        Integer poll = deque.pollFirst();
        if (poll.equals(maxDeque.peek())){
            //及时更新最大队列中的值
            maxDeque.pollFirst();
        }
        return poll;
    }
}
