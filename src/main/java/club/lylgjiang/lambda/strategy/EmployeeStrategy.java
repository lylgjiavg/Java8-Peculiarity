package club.lylgjiang.lambda.strategy;

/**
 * @Classname EmployeeStrategy
 * @Description 策略设计模式:抽象策略
 * @Date 2019/10/3 15:11
 * @Created by Jiavg
 */
@FunctionalInterface
public interface EmployeeStrategy<T> {
    
    public boolean strategy(T t);
    
}
