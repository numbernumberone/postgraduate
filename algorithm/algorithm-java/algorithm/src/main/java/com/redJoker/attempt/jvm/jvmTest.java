package com.redJoker.attempt.jvm;

/**
 * @program: algorithm
 * @author: wangyanyang
 * @create: 2019-07-27 20:25
 **/
public class jvmTest {
    public static void main(String[] args) throws Exception {
        System.gc(); // 尝试清除由监测工具生成的临时对象
        Thread.sleep(2000L);

        byte[] obj1 = new byte[1024 * 1024 * 2];
        //执行完这一行之后各区使用情况: Eden[obj1]: 2/15, S0: 0/15, S1: 0/15, Old: 0/45

        byte[] obj2 = new byte[1024 * 1024 * 2];
        //执行完这一行之后各区使用情况: Eden[obj1,obj2]: 4/15, S0: 0/15, S1: 0/15, Old: 0/45

        byte[] obj3 = new byte[1024 * 1024 * 12];
        //对象obj3创建成功之前，虚拟机检测到Eden剩余空间(15-4=11)不足以分配给obj3，因此触发第一次Minor GC来释放空间给obj3，
        // obj1和obj2晋升到幸存区，年龄为1，各区使用情况: Eden[obj3]: 12/15, S0: 0/15, S1[obj1(age=1),obj2(age=1)]: 4/15, Old: 0/45

        obj3 = null; //obj3不再有任何引用关联，下次GC的时候将会被回收

        byte[] obj4 = new byte[1024 * 1024 * 4];
        //对象obj4创建成功之前，虚拟机检测到Eden剩余空间(15-12=3)不足以分配给obj4，
        // 因此触发第二次Minor GC来释放空间给obj4，这次GC中obj3会被回收，
        // 之后各区使用情况: Eden[obj4]: 4/15, S0:[obj1(age=2),obj2(age=2)]: 4/15, S1: 0/15, Old: 0/45

        byte[] obj5 = new byte[1024 * 1024 * 12];
//对象obj5创建成功之前，虚拟机检测到Eden剩余空间(15-4=11)不足以分配给obj5，因此触发第三次MinorGC来释放空间给obj5，
// 这次GC中由于obj1,obj2的年龄都到达了阈值2岁，所以这两个对象将被晋升到老年代，
// 之后各区使用情况:Eden[obj5]: 12/15, S0: 0/15, S1[obj4(age=1)]: 4/15, Old[obj1,obj2]: 4/45
    }
}
