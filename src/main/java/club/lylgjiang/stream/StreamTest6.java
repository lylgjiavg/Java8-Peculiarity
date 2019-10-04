package club.lylgjiang.stream;

/**
 * @Classname StreamTest6
 * @Description Stream终止操作
 * @Date 2019/10/4 19:37
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 归约
 * ①reduce(BinaryOperator b)
 *      可以将流中元素反复结合起来，得到一个值。返回 Optional<T>
 * ②reduce(T iden, BinaryOperator b)
 *      可以将流中元素反复结合起来，得到一个值。返回 T
 *      
 * 备注：map 和 reduce 的连接通常称为 map-reduce 模式，因 Google 用它
 * 来进行网络搜索而出名。
 */
public class StreamTest6 {

    private List<Employee> emps1 = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 55, 4444.33),
            new Employee("王五", 40, 7777.33),
            new Employee("赵六", 20, 9999.33),
            new Employee("田七", 18, 2222.33)
    );
    
    @Test
    public void test01(){
        Stream<Employee> stream = emps1.stream();
        Integer reduce = stream.map(Employee::getAge)
                .reduce(0, (x, y) -> {
                    return x + y;
                });
        System.out.println(reduce);
        System.out.println("-------------------------------");

        Stream<Employee> stream1 = emps1.stream();
        Optional<Integer> reduce1 = stream1.map(Employee::getAge)
                .reduce((a1, a2) -> {
                    return a1 + a2;
                });
        System.out.println(reduce1.get());
    }
    
}
