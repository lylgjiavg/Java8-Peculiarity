package club.lylgjiang.lambda;

/**
 * @Classname LambdaTest2
 * @Description Lambda表达式基础语法:
 *                  Java8中引入一个新的操作符"->"该操作符称为箭头操作符或者Lambda操作符
 *                  箭头操作符将Lambda表达式拆分为两个部分.
 *              左侧:Lambda表达式的参数列表
 *              右侧:Lambda表达式所执行的功能,即Lambda体
 * @Date 2019/10/3 16:13
 * @Created by Jiavg
 */

import org.junit.Test;

import java.util.Comparator;
import java.util.function.Consumer;

/**
 * Lambda表达式一:无参数,无返回值
 *      () -> System.out.println("Hello Lambda");
 *      
 * Lambda表达式二:一个参数,无返回值
 *      (arg) -> System.out.println("Hello Lambda " + arg);
 *      
 * Lambda表达式三:若只有一个参数,则小括号可以省略不写
 *      arg -> System.out.println("Hello Lambda " + arg);
 * 
 * Lambda表达式四:有两个及以上的参数,有返回值,并且Lambda体内有多条语句
 *      Comparator<Integer> comparable = (x, y) -> {
 *             System.out.printf("比较%d和%d:\n", x, y);
 *             return Integer.compare(x, y);
 *      };
 * 
 * Lambda表达式五:Lambda体内只有一条语句,则return和{}都可以省略
 *      Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
 *      
 * Lambda表达式六:Lambda表达式参数列表的数据类型可以省略不写,因为JVM编译器通过上下文推断出,数据类型,即"类型推断"
 *      Comparator<Integer> comparable = (Integer x, Integer y) -> Integer.compare(x, y);
 * 
 * 二.Lambda表达式需要"函数式接口"支持
 * 函数式接口:接口中只有一个抽象方法的接口,称为函数式接口.
 *          可以使用@FunctionalInterface修饰,用以检查是否是函数式接口.
 * 
 */
public class LambdaTest2 {
    
    @Test
    public void test01(){
        Runnable r = () -> System.out.println("Hello Lambda");
        r.run();
    }
    
    @Test
    public void test02(){
        Consumer<Integer> consumer = (arg) -> System.out.println("Hello Lambda " + arg);
        consumer.accept(666);
    }
    
    @Test
    public void test03(){
        Consumer<Integer> consumer = arg -> System.out.println("Hello Lambda " + arg);
        consumer.accept(666);
    }
    
    @Test
    public void test04(){
        Comparator<Integer> comparable = (x, y) -> {
            System.out.printf("比较%d和%d:\n", x, y);
            return Integer.compare(x, y);
        };
        System.out.println("result:" + comparable.compare(2, 3));
    }
    
    @Test
    public void test05(){
        Comparator<Integer> comparable = (x, y) -> Integer.compare(x, y);
        System.out.println("result:" + comparable.compare(2, 3));
    }
    
    @Test
    public void test06(){
        Comparator<Integer> comparable = (Integer x, Integer y) -> Integer.compare(x, y);
        System.out.println("result:" + comparable.compare(2, 3));
    }
    
}
