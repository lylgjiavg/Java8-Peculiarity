package club.lylgjiang.stream;

/**
 * @Classname StreamTest2
 * @Description Stream中间操作:
 * @Date 2019/10/4 13:47
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Stream;

/**
 * 多个中间操作可以连接起来形成一个 流水线，除非流水线上触发终止操作，否则中间操作不会执行任何的处理！
 * 而在终止操作时一次性全部处理，称为“惰性求值”。
 * 
 * 筛选与切片:
 * ①filter(Predicate p)
 *      接收 Lambda ，从流中排除某些元素。
 * ②distinct()
 *      筛选，通过流所生成元素的hashCode()和equals()去除重复元素
 * ③limit(long maxSize)
 *      截断流，使其元素不超过给定数量。
 * ④skip(long n)
 *      跳过元素，返回一个扔掉了前n个元素的流。若流中元素不足n个，则返回一个空流。与 limit(n)互补
 */
public class StreamTest2 {
    
    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 55, 4444.33),
            new Employee("王五", 40, 7777.33),
            new Employee("赵六", 20, 9999.33),
            new Employee("田七", 18, 2222.33),
            new Employee("田七", 18, 2222.33),
            new Employee("田七", 18, 2222.33)
    );

    /**
     * 内部迭代:迭代操作由Stream API完成
     */
    @Test
    public void test01(){

        Stream<Employee> stream = emps.stream()
                .filter((e) -> e.getSalary() > 3000);
        
        stream.forEach(System.out::println);
    }

    /**
     * 外部迭代
     */
    @Test
    public void test001(){

        Iterator<Employee> iterator = emps.iterator();
        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee);
        }
    }
    
    @Test
    public void test02(){
        Stream<Employee> stream = emps.stream().distinct();
        
        stream.forEach(System.out::println);
    }
    
    @Test
    public void test03(){
        Stream<Employee> stream = emps.stream()
                .limit(2);
        
        stream.forEach(System.out::println);
    }
    
    @Test
    public void test04(){
        Stream<Employee> stream = emps.stream()
                .skip(2);
        
        stream.forEach(System.out::println);
    }
    
}
