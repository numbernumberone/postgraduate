package com.redJoker.algorithm.primary;

import java.util.*;

public class 两数求和 {
    /**
     * 遇到的坑:
     *  既然是做算法题, 对于一些集合就不要去使用了,影响执行效率。即便是使用集合 也要将集合的高性能发挥出来
     */
    public int[] twoSum(int[] nums, int target) {
        //存放结果
        List<Map<String, Integer>> lists = new ArrayList<Map<String, Integer>>();
        //要返回的结果
        List<Integer> re=new ArrayList<Integer>();

        //停止循环的节点
        for(int i = 0; i < nums.length - 1; i++)
            for(int j = i + 1;j < nums.length; j++ ) {
                if(nums[i] + nums[j] == target) {
                    re.add(i);
                    re.add(j);
                }
            }
        //转换结果
        int[] result = new int[re.size()];
        for(int i = 0;i < re.size(); i++){
            result[i]=re.get(i);
        }
        return result;
    }

    /**
     * 下述方法巧妙使用了map集合 使用空间换取时间 对于常规的暴力方式需要双层for循环, 时间复杂度是O(n^2)
     *  但是使用了集合后, 对于给定了和 给行了一个加数,肯定可以求的另外一个加数。 然后在我们的map中去寻找另外一个加数,如果有 直接返回, 如果没有, 就将另外一个加数信息放到map中。
     *  只进行了一遍for循环的遍历, 时间复杂度变为O(n)
     */
    public int[] twoSum2(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if(map.containsKey(num)) {
                return new int[] {i,map.get(num)};
            }
            //有点意思
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }

}
