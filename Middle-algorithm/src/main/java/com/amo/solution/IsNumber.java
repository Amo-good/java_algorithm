package com.amo.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * (1)数值（按顺序）可以分成以下几个部分：
 * 1. 若干空格
 * 2. 一个小数或者整数
 * 3. （可选）一个'e'或'E'，后面跟着一个整数
 * 4. 若干空格
 * (2)小数（按顺序）可以分成以下几个部分：
 * 1.（可选）一个符号字符（'+' 或 '-'）
 * 2. 下述格式之一：
 *      至少一位数字，后面跟着一个点 '.'
 *      至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 *      一个点 '.' ，后面跟着至少一位数字
 *(3)整数（按顺序）可以分成以下几个部分：
 *1.（可选）一个符号字符（'+' 或 '-'）
 *2. 至少一位数字
 *
 */
public class IsNumber {
    public boolean isNumber(String s) {
        Map[] states = {
                new HashMap() {{ put(' ', 0); put('s', 1); put('d', 2); put('.', 4); }}, // 0.
                new HashMap() {{ put('d', 2); put('.', 4); }},                           // 1.
                new HashMap() {{ put('d', 2); put('.', 3); put('e', 5); put(' ', 8); }}, // 2.
                new HashMap() {{ put('d', 3); put('e', 5); put(' ', 8); }},              // 3.
                new HashMap() {{ put('d', 3); }},                                        // 4.
                new HashMap() {{ put('s', 6); put('d', 7); }},                           // 5.
                new HashMap() {{ put('d', 7); }},                                        // 6.
                new HashMap() {{ put('d', 7); put(' ', 8); }},                           // 7.
                new HashMap() {{ put(' ', 8); }}                                         // 8.
        };
        int p = 0;
        char t;
        for(char c : s.toCharArray()) {
            if(c >= '0' && c <= '9') t = 'd';
            else if(c == '+' || c == '-') t = 's';
            else if(c == 'e' || c == 'E') t = 'e';
            else if(c == '.' || c == ' ') t = c;
            else t = '?';
            if(!states[p].containsKey(t)) return false;
            p = (int)states[p].get(t);
        }
        return p == 2 || p == 3 || p == 7 || p == 8;
    }

}
