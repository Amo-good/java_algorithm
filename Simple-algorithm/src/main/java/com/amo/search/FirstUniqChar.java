package com.amo.search;

import com.sun.org.apache.xpath.internal.operations.Bool;
import org.omg.PortableInterceptor.INACTIVE;

import java.util.HashMap;
import java.util.HashSet;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 * 输入：s = "abaccdeff"
 * 输出：'b'
 * 输入：s = ""
 * 输出：' '
 */
public class FirstUniqChar {
    public char firstUniqChar(String s) {
        HashMap<Character, Boolean> map=new HashMap<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            map.put(c,!map.containsKey(c));
        }
        for (char c:chars){
            if (map.get(c)) return c;
        }
        return ' ';
    }
}
