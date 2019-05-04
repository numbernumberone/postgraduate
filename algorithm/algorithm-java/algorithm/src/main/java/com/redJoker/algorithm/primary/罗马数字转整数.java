package com.redJoker.algorithm.primary;

import java.util.HashMap;

public class 罗马数字转整数 {
    public int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        // 要返回的整数
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(map.containsKey(c)) {
                //是最后一个字符 直接取出结果返回
                if(i == s.length() - 1) {
                    return num += map.get(c);
                } else if('I' == c && 'V' == s.charAt(i + 1)) {
                    num += 4;
                    i++;
                } else if('I' == c && 'X' == s.charAt(i + 1)) {
                    num += 9;
                    i++;
                } else if('X' == c && 'L' == s.charAt(i + 1)) {
                    num += 40;
                    i++;
                } else if('X' == c && 'C' == s.charAt(i + 1)) {
                    num += 90;
                    i++;
                } else if('C' == c && 'D' == s.charAt(i + 1)) {
                    num += 400;
                    i++;
                } else if('C' == c && 'M' == s.charAt(i + 1)) {
                    num += 900;
                    i++;
                } else {
                    // 除了上述六种特殊情况 其余情况全部将字符对应的数字累加即可
                    num += map.get(c);
                }
            }
        }
        return num;
    }

    public static void main(String[] args) {
        罗马数字转整数 result = new 罗马数字转整数();
        System.out.println(result.romanToInt("MCMXCIV"));

    }
}
