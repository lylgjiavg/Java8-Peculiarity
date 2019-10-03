package club.lylgjiang.lambda.test;

/**
 * @Classname Fun2
 * @Description Lambda练习:函数式接口
 * @Date 2019/10/3 19:46
 * @Created by Jiavg
 */
@FunctionalInterface
public interface Fun2<T, R> {
    
    public R operator(T t1, T t2);
    
}
