package club.lylgjiang.stream;

/**
 * @Classname StreamTest4
 * @Description Stream中间操作
 * @Date 2019/10/4 15:48
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * 排序
 * ①sorted()
 *      产生一个新流，其中按自然顺序排序(Comparable)
 * ②sorted(Comparator  comp)
 *      产生一个新流，其中按比较器顺序排序(Comparator)
 */
public class StreamTest4 {

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 55, 4444.33),
            new Employee("王五", 40, 7777.33),
            new Employee("赵六", 20, 9999.33),
            new Employee("田七", 18, 2222.33)
            );
    
    @Test
    public void test01(){
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        Stream<String> sorted = Arrays.stream(strings)
                .sorted();
        
        sorted.forEach(System.out::println);
    }
    
    @Test
    public void test02(){
        Stream<Employee> sorted = emps.stream().sorted((e1, e2) -> {
            if (e1.getAge() == e2.getAge()) {
                return e1.getName().compareTo(e2.getName());
            } else {
                return e1.getAge().compareTo(e2.getAge());
            }
        });
        
        sorted.forEach(System.out::println);
    }
    
}
