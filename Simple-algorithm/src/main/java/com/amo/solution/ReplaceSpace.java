package com.amo.solution;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 * 输入：s = "We are happy."
 * 输出："We%20are%20happy."
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        //s.replace(" ", "%20") 最偷懒的方法
        if (s==null) return null;
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = 0; i <s.length(); i++) {
            char c = s.charAt(i);
            if (c==' ') stringBuilder.append("%20");
            else stringBuilder.append(c);
        }
        return stringBuilder.toString();
    }

}
