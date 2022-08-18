package com.amo.solution;

/**
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 */
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //第一个字符串作为模板
        String preFix=strs[0];
        for (int i = 0; i < preFix.length(); i++) {
            //取出前缀依次比较
            char fix=preFix.charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //只要有一个不满足就不匹配
                if (strs[j].length()==i||strs[j].charAt(i)!=fix)
                    return preFix.substring(0, i);
            }

        }
        return preFix;
    }
}
