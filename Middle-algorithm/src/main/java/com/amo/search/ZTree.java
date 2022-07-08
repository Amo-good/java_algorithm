package com.amo.search;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 从上到下打印
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，
 * 第二层按照从右到左的顺序打印，
 * 第三行再按照从左到右的顺序打印，其他行以此类推。
 * 做法
 * 利用双端队列的两端皆可添加元素的特性，设打印列表（双端队列） tmp ，并规定：
 * 奇数层 则添加至 tmp 尾部 ，
 * 偶数层 则添加至 tmp 头部
 */
public class ZTree {
    public List<List<Integer>> levelOrder(TreeNode root) {
        //用于保存列表
        List<List<Integer>> list=new ArrayList<>();
        if (root==null) return list;
        //层次打印需用到队列
        Queue<TreeNode> queue=new LinkedList<>();
        //先保存第一个节点
        queue.add(root);
        while (!queue.isEmpty()){
            //用来保存临时的层次变量
            LinkedList<Integer> tmp=new LinkedList<>();
            for (int i = queue.size(); i >0 ; i--) {
                TreeNode node = queue.poll();
                //第一层算偶数层，利用list.size()来判断当前层次
                if (list.size()%2==0){
                    //奇数层放最后，偶数层放前面
                    tmp.addLast(node.val);
                }else {
                    tmp.addFirst(node.val);
                }
                if (node.left!=null)queue.add(node.left);
                if (node.right!=null)queue.add(node.right);

            }
            list.add(tmp);
        }
        return list;
    }
}
