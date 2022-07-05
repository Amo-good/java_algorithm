package com.amo.solution;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * 输入: s = "abcdefg", k = 2
 * 输出: "cdefgab"
 */
public class LeftString {

    //利用三次反转实现
    public String reverseLeftWords(String s, int n) {
        if (s==null) return null;
        StringBuilder sb=new StringBuilder(s); //例如"abcdef"
        //先反转
        sb.reverse();//"fedcba"
        //再按n划分反转后的字符串
         String s1 = sb.substring(0, s.length()-n);//"fedc"
         String s2 = sb.substring(s.length()-n,s.length());//"ba"
         //再将字符串各自反转拼接
        StringBuilder reverse1 = new StringBuilder(s1).reverse();//cdef
        StringBuilder reverse2 = new StringBuilder(s2).reverse();//ab
        //最后拼接返回
        return reverse1.append(reverse2).toString();


    }
    //截取字符串，进行拼接
   /* public String reverseLeftWords(String s, int n) {
        if (s==null) return null;
        StringBuilder one=new StringBuilder();
        StringBuilder two=new StringBuilder();
        //先根据n拆分字符串后分别进行反转
        for (int i = 0; i <s.length(); i++) {
            //分别保存被分割的字符串
            if (i<n) one.append(s.charAt(i));
            else two.append(s.charAt(i));
        }
        return two.append(one).toString();
    }*/
}
