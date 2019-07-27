### 函数式接口: 
    定义:只包含一个抽象方法的接口,称之为函数式接口。
    特点:
        接口有且只有一个抽象方法。
        允许定义静态方法, 默认方法.
        还允许定义 java.lang.Object 里的 public 方法 
            hashCode(),equals(),clone()....
        PS: 如果接口满足上述条件, 加不加注解@FunctionalInterface
        都不影响,但是如果不满足上述条件, 即使加上注解也会报错。
        
    具体模版详见 com.redJoker.methodexercise.funcInterface.MyInterface
    为什么要用函数式接口:
    
    
   
#### 自定义函数式接口以及使用
    1. 无参无返回值 详情见 com.redJoker.methodexercise.funcInterface.DemoInterface
    2. 又参有返回值 详情见 com.redJoker.methodexercise.funcInterface.DemoInterface2
    3. Lambda 延迟执行
    4. 使用Lambda 作为方法的参数
    
    
     
    
    