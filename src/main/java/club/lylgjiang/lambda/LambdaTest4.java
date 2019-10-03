package club.lylgjiang.lambda;

/**
 * @Classname LambdaTest4
 * @Description Java内置的四大核心式函数接口
 * @Date 2019/10/3 20:20
 * @Created by Jiavg
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.logging.Logger;

/**
 * Consumer<T>:消费型接口
 *      void accept(T t);
 *      
 * Supplier<T>:供给型接口
 *      T get();
 *      
 * Function<T, R>:函数型接口
 *      R apply(T t);
 *      
 * Predicate<T>:断言型接口
 *      boolean test(T t);
 */
public class LambdaTest4 {
    
    @Test
    public void test01(){
        
        String log = "我是一只快乐的 Warning";
        printLog(log, (arg) -> {
            Logger logger = Logger.getLogger("log");
            logger.warning(log);
        });
    }
    public void printLog(String log ,Consumer<String> consumer){
        consumer.accept(log);
    }
    
    @Test
    public void test02(){
        List<Integer> randomList = getRandomList(10, () -> new Random().nextInt(100));
        randomList.forEach(System.out::println);
    }
    public List<Integer> getRandomList(int count, Supplier<Integer> supplier){
        List<Integer> list = new ArrayList<>();
        
        for (int i = 0; i < count; i++) {
            Integer random = supplier.get();
            list.add(random);
        }
        return list;
    }
    
    @Test
    public void test03(){
        List<String> strList = Arrays.asList("jlc", "lc", "znc", "ycg");
        List<Integer> integerList = operator(strList, (list) -> {
            List<Integer> strLengthList = new ArrayList<>();
            for (String str : list) {
                int length = str.length();
                strLengthList.add(length);
            }
            return strLengthList;
        });
        integerList.forEach(System.out::println);
    }
    public List<Integer> operator(List<String> list, Function<List<String>, List<Integer>> function){
        List<Integer> stringList = function.apply(list);
        return stringList;
    }
    
    @Test
    public void test04(){
        List<String> strList = Arrays.asList("jlc", "lc", "znc", "ycg", "jiavg", "jiang", "club");
        List<String> apply = testApply(strList, (list) -> {
            return list.length() > 3 ? true : false;
        });
        apply.forEach(System.out::println);
    }
    public List<String> testApply(List<String> strList, Predicate<String> predicate){
        List<String> list = new ArrayList<>();
        for (String str : strList) {
            if(predicate.test(str)){
                list.add(str);
            }
        }
        
        return list;
    }
    
}
