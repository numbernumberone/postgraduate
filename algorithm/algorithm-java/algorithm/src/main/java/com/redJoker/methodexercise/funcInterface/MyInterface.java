package com.redJoker.methodexercise.funcInterface;

import java.util.HashMap;
import java.util.Map;

@FunctionalInterface
public interface MyInterface<T> {
    /**
     * 抽象方法
     */
    void sayHello();

    /**
     * 静态方法
     */
    public static void sayHi() {
        System.out.println("static say Hi");
    }

    /**
     * 默认方法
     */
    public default void defaultMethod(){
        System.out.println("default say Hi");
    }

    /**
     * 允许定义 java.lang.Object 里的 public 方法
     * @param obj
     * @return
     */
    @Override
    boolean equals(Object obj);
}

/**
 * 该类演示的是函数式接口 无参数无返回值/
 */
class DemoInterface {
    public static void useInterface(MyInterface myInterface) {
        myInterface.sayHello();
    }
//    public static void main(String[] args) {
//        DemoInterface.useInterface(() -> System.out.println("Hello..."));
//    }


//    public static void main(String[] args) throws Exception{
//        System.gc(); // 尝试清除由监测工具生成的临时对象
//        Thread.sleep(10000L);
//        byte[] obj1 = new byte[1024 * 1024 * 1];
//        byte[] obj2 = new byte[1024 * 1024 * 10];
//        byte[] obj3 = new byte[1024 * 1024 * 20];
//        //byte[] obj4 = new byte[1024 * 1024 * 10];
//        //byte[] obj5 = new byte[1024 * 1024 * 10];
//    }

    public static void main(String[] args) {
        Map map = new HashMap<>();
        map.put("123","123");
        map.put("456","456");
        map.put("asd",123);
        System.out.println(map.get("zzz"));
    }


}




