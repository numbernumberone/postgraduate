package com.redJoker.methodexercise.funcInterface;

@FunctionalInterface
public interface MyInterface3 {
    /**
     * 抽象方法
     */
    String buildMessgae();
}

/**
 *  该类演示的是函数式接口 有参数有返回值
 */
class DemoInterface3 {
    public void sumValue(int a, MyInterface3 myInterface) {
        if(1 == a) {
            System.out.println(myInterface.buildMessgae());
        } else {
            System.out.println("莫的东西");
        }
    }

    public static void main(String[] args) {
        String msgA = "Hello ";
        String msgB = "World ";
        String msgC = "Java";

        DemoInterface3 demo = new DemoInterface3();
        demo.sumValue(2,() -> msgA + msgB + msgC);
    }
}


