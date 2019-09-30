package com.redJoker.methodexercise.funcInterface;

@FunctionalInterface
public interface MyInterface2 {
    /**
     * 抽象方法
     */
    int sum(int a, int b);
}

/**
 *  该类演示的是函数式接口 有参数有返回值
 */
class DemoInterface2 {
    public int sumValue(int a, int b, MyInterface2 myInterface) {
        return myInterface.sum(a,b);
    }

    public static void main(String[] args) {
        DemoInterface2 demo = new DemoInterface2();
        System.out.println(demo.sumValue(1, 2, (m, n) -> m - n));
    }
}


