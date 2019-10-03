package club.lylgjiang.lambda.strategy;

import club.lylgjiang.lambda.pojo.Employee;

/**
 * @Classname EmployeeStrategyBySalary
 * @Description 策略设计模式:具体策略(按工资)
 * @Date 2019/10/3 15:19
 * @Created by Jiavg
 */
public class EmployeeStrategyBySalary implements EmployeeStrategy<Employee>{
    
    @Override
    public boolean strategy(Employee employee) {
        return employee.getSalary() > 5000;
    }
    
}
