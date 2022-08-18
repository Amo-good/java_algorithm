package com.amo.solution;

import java.util.HashMap;
import java.util.Map;

/**
 * 罗马数字转整数
 * 字符          数值
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 *
 * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
 * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
 * C可以放在D(500) 和M(1000) 的左边，来表示400 和900
 *
 */
public class RomanToInt {
    public int romanToInt(String s) {
        //定义字符表示的数值
        Map<Character,Integer> map=new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        //获取字符串长度
        int length=s.length();
        //用于统计整数值,保存前缀值
        int sum=0,pre=map.get(s.charAt(0));
        for (int i = 1; i <length ; i++) {
            int num=map.get(s.charAt(i));
            //如果当前值大于前缀值，说明是减法
            if (pre>num){
                sum-=pre;
            }else{
                sum+=pre;
            }
            pre=num;
        }
        sum+=pre;
       return sum;
    }
}
