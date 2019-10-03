package club.lylgjiang.lambda;

import club.lylgjiang.lambda.pojo.Employee;
import club.lylgjiang.lambda.strategy.EmployeeStrategy;
import club.lylgjiang.lambda.strategy.EmployeeStrategyByAge;
import club.lylgjiang.lambda.strategy.EmployeeStrategyBySalary;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 * @Classname LambdaTest
 * @Description Lambda测试类
 * @Date 2019/10/3 14:52
 * @Created by Jiavg
 */
public class LambdaTest {
    
    private List<Employee> emps = Arrays.asList(
            new Employee("张三", 22, 3333.33),
            new Employee("李四", 55, 4444.33),
            new Employee("王五", 40, 7777.33),
            new Employee("赵六", 20, 9999.33),
            new Employee("田七", 18, 2222.33)
    );
    
    /**
     * 需求:
     *  1.查询员工年龄大于30的雇员
     *  2.查询员工薪资大于5000的雇员
     */

    /**
     * 方法一:普通思路求解
     */
    @Test
    public void test01(){
        // 需求1
        List<Employee> requires1 = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getAge() > 30){
                requires1.add(emp);
            }
        }
        System.out.println("年龄大于30的雇员:"+ Arrays.toString(requires1.toArray()));

        // 需求2
        List<Employee> requires2 = new ArrayList<>();

        for (Employee emp : emps) {
            if(emp.getSalary() > 5000){
                requires2.add(emp);
            }
        }
        System.out.println("薪资大于5000的雇员:"+ Arrays.toString(requires2.toArray()));
    }

    /**
     * 方法二:策略设计模式
     */
    @Test
    public void test02(){
        // 需求1
        List<Employee> requires1 = filterEmployee(emps, new EmployeeStrategyByAge());
        System.out.println("年龄大于30的雇员:"+ Arrays.toString(requires1.toArray()));
        
        // 需求2
        List<Employee> requires2 = filterEmployee(emps, new EmployeeStrategyBySalary());
        System.out.println("薪资大于5000的雇员:"+ Arrays.toString(requires2.toArray()));
    }
    public List<Employee> filterEmployee(List<Employee> employees, EmployeeStrategy<Employee> strategy){
        List<Employee> requires = new ArrayList<>();

        for (Employee emp : emps) {
            if(strategy.strategy(emp)){
                requires.add(emp);
            }
        }
        return requires;
    }


    /**
     * 方法三:策略设计模式+内部类
     */
    @Test
    public void test03(){
        // 需求1
        List<Employee> requires1 = filterEmployee(emps, new EmployeeStrategy<Employee>() {
            @Override
            public boolean strategy(Employee emp) {
                return emp.getAge() > 30;
            }
        });
        System.out.println("年龄大于30的雇员:"+ Arrays.toString(requires1.toArray()));

        // 需求2
        List<Employee> requires2 = filterEmployee(emps, new EmployeeStrategy<Employee>() {
            @Override
            public boolean strategy(Employee emp) {
                return emp.getSalary() > 5000;
            }
        });
        System.out.println("薪资大于5000的雇员:"+ Arrays.toString(requires2.toArray()));
    }


    /**
     * 方法四:策略设计模式+Lambda
     */
    @Test
    public void test04(){
        // 需求1
        List<Employee> requires1 = filterEmployee(emps, (emp) -> emp.getAge() > 30);
        System.out.println("年龄大于30的雇员:"+ Arrays.toString(requires1.toArray()));
        // requires1.forEach(System.out::println);
        
        // 需求2
        List<Employee> requires2 = filterEmployee(emps, (emp) -> emp.getSalary() > 5000);
        System.out.println("薪资大于5000的雇员:"+ Arrays.toString(requires2.toArray()));
        // requires2.forEach(System.out::println);
    }

    /**
     * 方法五:Stream API
     */
    @Test
    public void test05(){
        // 需求1
        emps.stream()
                .filter(employee -> employee.getAge() > 30)
                .forEach(System.out::println);

        System.out.println("-----------------------------------------");
        
        // 需求2
        emps.stream()
                .filter(employee -> employee.getSalary() > 5000)
                .forEach(System.out::println);
    }
}
