package club.lylgjiang.stream;

/**
 * @Classname StreamTest5
 * @Description Stream终止操作
 * @Date 2019/10/4 18:47
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * 终端操作会从流的流水线生成结果。其结果可以是任何不是流的值，例如：List、Integer，甚至是 void 。
 * 
 * 查找与匹配
 * ①allMatch(Predicate p)
 *      检查是否匹配所有元素
 * ②anyMatch(Predicate p)
 *      检查是否至少匹配一个元素
 * ③noneMatch(Predicate p)
 *      检查是否没有匹配所有元素
 * ④findFirst()
 *      返回第一个元素
 * ⑤findAny()
 *      返回当前流中的任意元素
 * ⑥count()
 *      返回流中元素总数
 * ⑦max(Comparator c)
 *      返回流中最大值
 * ⑧min(Comparator c)
 *      返回流中最小值
 * ⑨forEach(Consumer c)
 *      内部迭代(使用 Collection接口需要用户去做迭代，称为外部迭代。相反，Stream API使用内部
 *      迭代——它帮你把迭代做了)
 * 
 */
public class StreamTest5 {
    
    private List<Employee> emps1 = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 55, 4444.33),
            new Employee("王五", 40, 7777.33),
            new Employee("赵六", 20, 9999.33),
            new Employee("田七", 18, 2222.33)
    );
    private List<Employee> emps2 = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 22, 4444.33),
            new Employee("王五", 22, 7777.33)
    );
    
    
    @Test
    public void test01(){
        Stream<Employee> stream1 = emps1.stream();
        boolean allMatch1 = stream1.allMatch(employee -> {
            return employee.getAge() == 22;
        });
        System.out.println(allMatch1);// false
        
        Stream<Employee> stream2 = emps2.stream();
        boolean allMatch2 = stream2.allMatch(employee -> {
            return employee.getAge() == 22;
        });
        System.out.println(allMatch2);// true
    }
    
    @Test
    public void test02(){
        Stream<Employee> stream = emps1.stream();
        boolean anyMatch = stream.anyMatch(employee -> {
            return employee.getName().equals("张三");
        });
        System.out.println(anyMatch);// true
        
        Stream<Employee> stream2 = emps1.stream();
        boolean anyMatch2 = stream2.anyMatch(employee -> {
            return employee.getName().equals("李欣");
        });
        System.out.println(anyMatch2);// false
    }
    
    @Test
    public void test03(){
        Stream<Employee> stream = emps1.stream();
        boolean anyMatch = stream.noneMatch(employee -> {
            return employee.getName().equals("张三");
        });
        System.out.println(anyMatch);// false
        
        Stream<Employee> stream2 = emps1.stream();
        boolean anyMatch2 = stream2.noneMatch(employee -> {
            return employee.getName().equals("李欣");
        });
        System.out.println(anyMatch2);// true
    }

    @Test
    public void test04(){
        Stream<Employee> stream = emps1.stream();
        Optional<Employee> first = stream.findFirst();
        if(first.isPresent()){
            System.out.println(first.get());
        }
    }
    
    @Test
    public void test05(){
        Stream<Employee> stream = emps1.parallelStream();
        Optional<Employee> first = stream.findAny();
        if(first.isPresent()){
            System.out.println(first.get());
        }
    }
    
    @Test
    public void test06(){
        Stream<Employee> stream = emps1.parallelStream();
        long count = stream.count();
        System.out.println(count);
    }
    
    @Test
    public void test07(){
        Stream<Employee> stream = emps1.parallelStream();
        Optional<Employee> max = stream.max((e1, e2) -> {
            return e1.getAge().compareTo(e2.getAge());
        });
        if (max.isPresent()) {
            System.out.println(max.get());
        }
    }
    
    @Test
    public void test08(){
        Stream<Employee> stream = emps1.parallelStream();
        Optional<Employee> max = stream.min((e1, e2) -> {
            return e1.getAge().compareTo(e2.getAge());
        });
        if (max.isPresent()) {
            System.out.println(max.get());
        }
    }
    
    @Test
    public void test09(){
        Stream<Employee> stream = emps1.stream();
        stream.forEach((emp) -> {
            System.out.println(emp);
        });
    }
    
}
