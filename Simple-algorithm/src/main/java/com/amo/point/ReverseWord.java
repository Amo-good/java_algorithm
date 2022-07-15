package com.amo.point;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，
 * 标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * 说明
 * 无空格字符构成一个单词。
 * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
 * 如果两个单词间有多余的空格，将反转后单词间的空格减少到只含一个。
 *
 */
public class ReverseWord {
    //双指针，从后面开始截取字符串
    public String reverseWords(String s) {
        //先去除前后空格
        String trim = s.trim();
        //i负责向前搜索单词的开头，j负责记录单词的结尾
        int i=s.length()-1,j=i;
        StringBuilder builder=new StringBuilder();
        while (i>=0){
            //搜索单词开头
            while (i>=0&&s.charAt(i)!=' ') i--;
            //循环到这里说明已经找到单词开头substring[i+1,j+1)
            builder.append(s.substring(i+1,j+1)+" ");
            //搜索下一个单词结尾
            while (i>=0&&s.charAt(i)==' ')i--;
            j=i;//j指向下一个单词的结尾
        }
        return builder.toString().trim();
    }




        //分割+排序
/*    public String reverseWords(String s) {
        //先去除前后空格
        String trim = s.trim();
        //以空格分隔单词
        String[] s1 = trim.split(" ");
        StringBuilder builder=new StringBuilder();
        //倒序遍历
        for (int i=s1.length-1;i>=0 ; i--) {
            //遇到空单词跳过 注意此处为""而不是" "
            if ("".equals(s1[i])) continue;
            builder.append(s1[i]+" ");
        }
        return builder.toString().trim();
    }*/
}
