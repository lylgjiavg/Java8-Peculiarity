package club.lylgjiang.optional;

import club.lylgjiang.lambda.pojo.Employee;
import jdk.nashorn.internal.runtime.options.Option;
import org.junit.Test;

import java.util.Optional;

/**
 * @Classname OptionalTest
 * @Description Optional测试类
 * @Date 2019/10/5 9:40
 * @Created by Jiavg
 */

/**
 * 一、Optional 容器类：用于尽量避免空指针异常
 * 	Optional.of(T t) : 创建一个 Optional 实例
 * 	Optional.empty() : 创建一个空的 Optional 实例
 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
 * 	isPresent() : 判断是否包含值
 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
 */
public class OptionalTest {
    
    @Test
    public void test01(){
        Optional<Employee> optional = Optional.of(null);    // java.lang.NullPointerException
        if(optional.isPresent()){
            System.out.println("输出:");
            System.out.println(optional.get());
        }
    }
    
    @Test
    public void teat02(){
        Optional<Employee> optional = Optional.empty();
        if (optional.isPresent()) {
            System.out.println("输出:");          // 此部分无输出
            System.out.println(optional.get());
        }
    }
    
    @Test
    public void teat03(){
        Optional<Employee> optional = Optional.ofNullable(null);
        if (optional.isPresent()) {
            System.out.println("输出1:");         // 此部分无输出
            System.out.println(optional.get());
        }

        Optional<Employee> optional2 = Optional.ofNullable(new Employee());
        if (optional2.isPresent()) {
            System.out.println("输出2:");
            System.out.println(optional2.get());
        }
    }
    
    @Test
    public void teat04(){
        Optional<Employee> optional = Optional.ofNullable(null);
        Employee employee = optional.orElse(new Employee("jlc", 20, 8888.88));
        System.out.println(employee);       // Employee{name='jlc', age=20, salary=8888.88}
    }
    
    @Test
    public void teat05(){
        int index = 0;
        
        Optional<Employee> optional = Optional.ofNullable(null);
        Employee employee = optional.orElseGet(() -> {
            switch (index){
                case 0:
                    return new Employee("ycg", 20, 8888.88);
                case 1:
                    return new Employee("znc", 21, 18888.88);
                case 2:
                    return new Employee("lx", 22, 28888.88);
                default: 
                    return new Employee("jlc", 18, 58888.88);
            }
        });
        System.out.println(employee);       // Employee{name='ycg', age=20, salary=8888.88}
    }
    
    @Test
    public void test06(){
        Optional<Employee> optional = Optional.of(new Employee("jlc", 18, 888.88));
        Optional<String> optionalS = optional.map((e) -> {
            return e.getName();
        });
        System.out.println(optionalS.get());
    }
    
    @Test
    public void test07(){
        Optional<Employee> optional = Optional.of(new Employee(null, 18, 888.88));
        Optional<String> optionalS = optional.flatMap((e) -> {  // java.lang.NullPointerException
            return Optional.of(e.getName());
        });
        System.out.println(optionalS.get());
    }
    
}
