package club.lylgjiang.lambda.strategy;

import club.lylgjiang.lambda.pojo.Employee;

/**
 * @Classname EmployeeStrategyByAge
 * @Description 策略设计模式:具体策略(按年龄)
 * @Date 2019/10/3 15:15
 * @Created by Jiavg
 */
public class EmployeeStrategyByAge implements EmployeeStrategy<Employee>{
    
    @Override
    public boolean strategy(Employee emloyee) {
        return emloyee.getAge() > 30;
    }
    
}
