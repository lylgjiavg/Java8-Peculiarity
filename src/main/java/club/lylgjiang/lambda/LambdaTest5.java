package club.lylgjiang.lambda;

/**
 * @Classname LambdaTest5
 * @Description Lambda:方法引用,构造器引用,数组引用
 * @Date 2019/10/3 23:25
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Comparator;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 一.方法引用:若Lambda体中的内容有方法已经实现了,我们可以使用"方法引用"
 *            (可以理解为方法引用是Lambda表达式的另一种表现形式)
 *            
 * 主要由三种语法形式:
 *      ①对象::实例方法
 *      ②类::静态方法名
 *      ③类::实例方法名
 * 注意:
 *      ①Lambda体中调用方法的参数列表与返回值类型,要与函数式接口中抽象方法的参数列表和返回值类型保持一致!
 *      ②若Lambda参数列表中的第一个参数是实例方法的调用者,而第二个参数是实例方法的参数时可以使用类::实例方法名
 *      
 * 二.构造器引用
 * 
 * 格式:
 *      ClassName::new
 * 注意:需要调用的构造器的参数列表要与函数式接口中抽象方法的参数列表保持一致
 * 
 * 三.数组引用
 * 
 * 格式:
 *      Type[]:new
 * 
 */
public class LambdaTest5 {
    
    @Test
    public void test01(){

        // ------------普通Lambda---------------
        PrintStream out = System.out;
        Consumer<String> consumer = (str) -> out.println(str);
        consumer.accept("log");
        
        // ------------对象::实例方法---------------
        PrintStream out1 = System.out;
        Consumer<String> consumer1 = out1::println;
        consumer1.accept("log1");
    }
    
    @Test
    public void test02(){
        
        // ------------普通Lambda---------------
        Comparator<Integer> comparator = (x, y) -> Integer.compare(x, y);
        int compare = comparator.compare(1, 2);
        System.out.println(compare);

        // ------------类::静态方法名---------------
        Comparator<Integer> comparator1 = Integer::compare;
        int compare1 = comparator.compare(1, 2);
        System.out.println(compare1);
    }
    
    @Test
    public void test03(){
        
        // ------------普通Lambda---------------
        String str = "abc";
        Function<String, Integer> function = (x) -> str.compareTo(x);
        int compare = function.apply("bcd");
        System.out.println(compare);

        // ------------类::实例方法名---------------
        BiFunction<String, String, Integer> function1 = String::compareTo;
        int compare1 = function1.apply("abc", "bcd");
        System.out.println(compare1);
    }
    
    @Test
    public void test04(){
        // 无参构造
        Supplier<Employee> supplier = Employee::new;
        Employee employee = supplier.get();
        System.out.println(employee);

        // 有参构造
        BiFunction<String, Integer, Employee> biFunction = Employee::new;
        Employee jlc = biFunction.apply("jlc", 20);
        System.out.println(jlc);
    }
    
    @Test
    public void test05(){
        
        Function<Integer, String[]> function = String[]::new;
        String[] apply = function.apply(10);
        System.out.println(apply.length);
    }
    
}
