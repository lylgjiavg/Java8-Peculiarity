package club.lylgjiang.stream;

/**
 * @Classname StreamTest7
 * @Description Stream终止操作
 * @Date 2019/10/4 20:01
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * 收集
 * ①collect(Collector c)
 *      将流转换为其他形式。接收一个 Collector接口的实现，用于给Stream中元素做汇总的方法.
 *      
 * Collector 接口中方法的实现决定了如何对流执行收集操作(如收集到 List、Set、Map)。
 * 但是 Collectors 实用类提供了很多静态方法，可以方便地创建常见收集器实例，具体
 * 方法与实例如下表：
 * 
 * ①toList List<T> 把流中元素收集到List
 *      List<Employee> emps= list.stream().collect(Collectors.toList());
 * ②toSet Set<T> 把流中元素收集到Set
 *      Set<Employee> emps= list.stream().collect(Collectors.toSet());
 * ③toCollection Collection<T> 把流中元素收集到创建的集合
 *      Collection<Employee>emps=list.stream().collect(Collectors.toCollection(ArrayList::new));
 * ④counting Long 计算流中元素的个数
 *      long count = list.stream().collect(Collectors.counting());
 * ⑤summingInt Integer 对流中元素的整数属性求和
 *      inttotal=list.stream().collect(Collectors.summingInt(Employee::getSalary));
 * ⑥averagingInt Double 计算流中元素Integer属性的平均值
 *      doubleavg= list.stream().collect(Collectors.averagingInt(Employee::getSalary));
 * ⑦summarizingInt IntSummaryStatistics 收集流中Integer属性的统计值。如：平均值
 *      IntSummaryStatisticsiss= list.stream().collect(Collectors.summarizingInt(Employee::getSalary));
 * ⑧joining String 连接流中每个字符串
 *      String str= list.stream().map(Employee::getName).collect(Collectors.joining());
 * ⑨maxBy Optional<T> 根据比较器选择最大值
 *      Optional<Emp>max= list.stream().collect(Collectors.maxBy(comparingInt(Employee::getSalary)));
 * ⑩minBy Optional<T> 根据比较器选择最小值
 *      Optional<Emp> min = list.stream().collect(Collectors.minBy(comparingInt(Employee::getSalary)));
 * ⑪reducing 归约产生的类型 从一个作为累加器的初始值开始，利用BinaryOperator与流中元素逐个结合，
 *      从而归约成单个值
 *      inttotal=list.stream().collect(Collectors.reducing(0, Employee::getSalar, Integer::sum));
 * ⑫collectingAndThen 转换函数返回的类型 包裹另一个收集器，对其结果转换函数
 *      inthow= list.stream().collect(Collectors.collectingAndThen(Collectors.toList(), List::size));
 * ⑬groupingBy Map<K, List<T>> 根据某属性值对流分组，属性为K，结果为V
 *      Map<Emp.Status, List<Emp>> map= list.stream()
 *          .collect(Collectors.groupingBy(Employee::getStatus));
 * ⑭partitioningBy Map<Boolean, List<T>> 根据true或false进行分区
 *      Map<Boolean,List<Emp>>vd= list.stream().collect(Collectors.partitioningBy(Employee::getManage));
 * 
 */
public class StreamTest7 {

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
        List<Integer> collect = stream.map(Employee::getAge)
                .collect(Collectors.toList());
        
        collect.forEach(System.out::println);
    }
    
    @Test
    public void test02(){
        Stream<Employee> stream = emps1.stream();
        Set<String> collect = stream.map(Employee::getName).collect(Collectors.toSet());
        
        collect.forEach(System.out::println);
    }
    
    @Test
    public void test03(){
        Stream<Employee> stream = emps1.stream();
        LinkedList<Employee> collect = stream.collect(Collectors.toCollection(LinkedList::new));
        
        collect.forEach(System.out::println);
    } 
    
    @Test
    public void test04(){
        Stream<Employee> stream = emps1.stream();
        Double collect = stream.collect(Collectors.averagingDouble(Employee::getSalary));
        System.out.println(collect);
    }
    
    @Test
    public void test05(){
        Stream<Employee> stream = emps1.stream();
        Long collect = stream.collect(Collectors.counting());
        System.out.println(collect);
    }
    
    @Test
    public void test06(){
        Stream<Employee> stream = emps1.stream();
        Optional<Double> collect = stream.map(Employee::getSalary).collect(Collectors.maxBy(Double::compare));
        System.out.println(collect.get());
    }
    
    @Test
    public void test07(){
        Stream<Employee> stream = emps1.stream();
        Optional<Employee> collect = stream
                .collect(Collectors.minBy((Employee e1, Employee e2) -> {
                    return Double.compare(e1.getSalary(), e2.getSalary());
                }));
        System.out.println(collect.get());
    }
    
    @Test
    public void test08(){
        Stream<Employee> stream = emps1.stream();
        Double collect = stream.collect(Collectors.summingDouble(Employee::getSalary));
        System.out.println(collect);
    }
    
    @Test
    public void test09(){
        Stream<Employee> stream = emps1.stream();
        String collect = stream.map(Employee::getName).collect(Collectors.joining(",", "[", "]"));
        System.out.println(collect);
    }
    
    @Test
    public void test10(){
        Stream<Employee> stream = emps1.stream();
        Map<Boolean, List<Employee>> collect = stream.collect(Collectors.partitioningBy((employee) -> {
            return employee.getAge() > 40;
        }));
        System.out.println(collect);
    }
    
    @Test
    public void test11(){
        Stream<Employee> stream = emps1.stream();
        Map<String, List<Employee>> collect = stream.collect(Collectors.groupingBy(employee -> {
            if (employee.getAge() <= 35) {
                return "青年";
            } else if (employee.getAge() <= 50) {
                return "中年";
            } else {
                return "老年";
            }
        }));
        System.out.println(collect);
    }
    
    @Test
    public void test12(){
        Stream<Employee> stream = emps1.stream();
        DoubleSummaryStatistics dss = stream.collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println(dss.getCount());
        System.out.println(dss.getMax());
        System.out.println(dss.getAverage());
        System.out.println(dss.getMin());
        System.out.println(dss.getSum());
    }
    
}
