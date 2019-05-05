package com.redJoker.algorithm.primary;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个大小为 n 的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *
 * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 *
 * 示例 2:
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class 求众数 {
    public int majorityElement(int[] nums) {
        //特殊情况 只有一个数字的 那就是它本身
        if(nums.length == 1) return nums[0];

        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(nums[i])) {
                int num = map.get(nums[i]);
                num++;
                map.put(nums[i],num);
                //找到符合条件的众数,找到就退出
                if(num > nums.length / 2) {
                    return nums[i];
                }
            } else {
                map.put(nums[i],1);
            }
        }
        throw new RuntimeException("数组不符合规则");
    }

    /**
     * 耗时最短的方式
     *     摩尔投票法:
     *          假设第一个数字过半数(假设为众数)并设置一个计数器, 遍历后面的数字,相同则计数器加一 不同计数器减一 当计数器为0时候, 换其他数字为众数,
     *          遍历结束后, 计数器大于0 对应的那个数就是众数字。
     * @param nums
     * @return
     */
    public int majorityElement2(int[] nums) {
        //计数器
        int count = 0;
        int num = 0;
        for(int i : nums) {
            if(count == 0) {
                // 假设第一个数字为众数, 或者计数器为0 更换众数
                num = i;
            }
            if (i == num) {
                // 遍历到数字和选定的数字一致 计数器+1
                count++;
            } else {
                count--;
            }
        }
        return num;
    }

    public static void main(String[] args) {
        求众数 result = new 求众数();
        int nums[] = {2,2,1,1,1,2,2};
        System.out.println(result.majorityElement2(nums));
    }
}
