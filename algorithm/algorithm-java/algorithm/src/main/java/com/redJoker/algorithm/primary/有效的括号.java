package com.redJoker.algorithm.primary;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class 有效的括号 {

    /**
     * 1.善用集合
     * 2.还是之前说的:遍历的时候, 可以边遍历边做操作。不要将所有数据准备好了,再操作。
     */
    public static boolean isValid(String s) {
        Map<String,String> sign = new HashMap<String,String>();
        sign.put(")","(");
        sign.put("]","[");
        sign.put("}","{");

        /**
         * 栈中只放左前缀的字符
         */
        Stack<String> stack = new Stack<String>();
        for(int i = 0; i < s.length(); i++) {
            /**
             * 对于左前缀 直接让入栈操作 不做匹配
             */
            if(sign.containsKey(String.valueOf(s.charAt(i)))) {
                /**
                 * 遍历到的值 --> 符合右前缀范围  -> 将栈中的左前缀取出 进行比较
                 */
                String result = stack.isEmpty() ? "-" : stack.pop();

                /**
                 * 一旦发现取到的右前缀不符合预期的左前缀 直接返回false;
                 */
                if(!result.equals(sign.get(String.valueOf(s.charAt(i)))))
                    return false;
            } else {
                stack.push(String.valueOf(s.charAt(i)));
            }
        }
        return stack.empty();
    }


    /**
     * 该方法存在问题 需要想一想
     */
    public static boolean unValid(String s) {
        //后续用于比较是否符合规则
        String[] sign = {"()","{}","[]"};
        Stack<Character> stack = new Stack<Character>();

        for(int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            stack.push(temp);
            if(stack.size() > 1) {
                //只有栈中大于等于两个字符,才可以取两个值 组成合适的字符串去比较
                Stack<Character> backup = new Stack<Character>();
                // TODO 这里存在问题
                String compare = String.valueOf(backup.peek()) + String.valueOf(backup.peek());
                for(int j = 0; j < sign.length; j++) {
                    //每次入栈 都要判断是否符合规则, 符合规则要出栈的
                    if(compare.equals(sign[j])) {
                        //找到匹配的 可以出栈 出栈两次 将匹配对出栈。
                        stack.pop();
                        stack.pop();
                    }
                }
            }
        }
        return stack.empty() ? true : false;
    }

    public static void main(String[] args) {
        System.out.println("--->" + 有效的括号.isValid("[][]"));
    }
}

