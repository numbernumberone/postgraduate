package com.redJoker.algorithm.primary;

import java.math.BigDecimal;

public class 整数反转 {
    public int reverse(int x) {
        //反转的数字
        int[] result = new int[32];
        //备份要操作的数据
        int n = x;
        //返回的数字
        BigDecimal re = new BigDecimal(0);

        for(int i = 0; i < result.length;) {
            if(i == 0 && n == 0) return 0;

            if(n == 0) break;

            result[i] = n % 10 < 0 ? -(n % 10) : n % 10;
            n = n / 10;
            if(i == 0 && result[i] == 0) {
                continue;
            }
            i++;
        }

        BigDecimal mul = x > 0 ? new BigDecimal(1) : new BigDecimal(-1);
        //计算要返回的值
        for(int r = result.length - 1; r >= 0; r--) {
            if(re.intValue() == 0 && result[r] == 0) continue;

            re = re.add(mul.multiply(new BigDecimal(result[r])));

            if(re.compareTo(new BigDecimal(Integer.MAX_VALUE)) > 0 || re.compareTo(new BigDecimal(Integer.MIN_VALUE)) < 0)
                return 0;
            mul = mul.multiply(new BigDecimal(10));
        }
        return re.intValue();
    }

    public static void main(String[] args) {
        整数反转 re = new 整数反转();
        System.out.println(re.reverse(1534236469));
    }
}
