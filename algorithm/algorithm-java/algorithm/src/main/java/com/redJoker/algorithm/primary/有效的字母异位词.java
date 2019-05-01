package com.redJoker.algorithm.primary;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class 有效的字母异位词 {

    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;

        Map<Character,Integer> first = new HashMap<Character,Integer>();
        Map<Character,Integer> second = new HashMap<Character,Integer>();

        //操作第一个字符串
        for(int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if(first.containsKey(c)) {
                //如果在集合中存在
                int num = first.get(c);
                num++;
                first.put(c,num);
            } else {
                first.put(c,1);
            }
        }

        //操作第二个字符串
        for(int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if(second.containsKey(c)) {
                //如果在集合中存在
                int num = second.get(c);
                num++;
                second.put(c,num);
            } else {
                second.put(c,1);
            }
        }

        //比较两个集合
        Iterator<Map.Entry<Character, Integer>> it = first.entrySet().iterator();
        while(it.hasNext()) {
            Character key = it.next().getKey();
            if(second.get(key) == null || second.get(key).intValue() != first.get(key).intValue())
                return false;
        }
        return true;
    }

    public static void main(String[] args) {
        有效的字母异位词 re = new 有效的字母异位词();
        System.out.println(re.isAnagram("a","ab"));
        //System.out.println(re.isAnagram("rat","car"));
        //System.out.println(re.isAnagram("anagram","nagaram"));
    }
}
