package club.lylgjiang.lambda;

import club.lylgjiang.lambda.pojo.Employee;
import club.lylgjiang.lambda.test.Fun;
import club.lylgjiang.lambda.test.Fun2;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @Classname LambdaTest3
 * @Description Lambda练习
 * @Date 2019/10/3 16:43
 * @Created by Jiavg
 */
public class LambdaTest3 {

    /**
     * 1.调用Collections.sort()方法，通过定制排序比较两个Employee(先按年龄比，年龄相同按姓名比)，使用Lambda作为参数传递。
     * 
     * 2.
     * ①	声明函数式接口，接口中声明抽象方法，public String getValue(String str);
     * ②	声明类TestLambda ,类中编写方法使用接口作为参数，将一个字符串转换成大写，
     *      并作为方法的返回值。
     * ③	再将一个字符串的第2个和第4个索引位置进行截取子串。
     * 3.
     * ①	声明一个带两个泛型的函数式接口，泛型类型为<T, R> T为参数，R为返回值
     * ②	接口中声明对应抽象方法
     * ③	在TestLambda类中声明方法，使用接口作为参数，计算两个long型参数的和。
     * ④	再计算两个long型参数的乘积。
     */

    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 55, 4444.33),
            new Employee("王五", 40, 7777.33),
            new Employee("赵六", 20, 9999.33),
            new Employee("田七", 18, 2222.33)
    );
    
    @Test
    public void test01(){
        Collections.sort(emps, (arg1, arg2) ->{
            if(arg1.getAge() == arg2.getAge()){
                return arg1.getName().compareTo(arg2.getName());
            }else {
                return Integer.compare(arg1.getAge(), arg2.getAge());
            }
        });
        
        emps.forEach(System.out::println);
    }
    
    @Test
    public void test02(){
        String stringHandle = stringHandle("jiavg", (str) -> {
//            return str.substring(0, 1).toUpperCase() + str.substring(1);
            return str.substring(2, 5);
        });

        System.out.println(stringHandle);
    }
    public String stringHandle(String str, Fun fun){
        return fun.getValue(str);
    }
    
    @Test
    public void test03(){
        Long result = multi(2L, 3L, (arg1, arg2) -> {
            return arg1 * arg2;
        });

        System.out.println(result);
    }
    public Long multi(Long arg1, Long arg2, Fun2<Long, Long> fun){
        
        return fun.operator(arg1, arg2);
    }
}
