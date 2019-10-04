package club.lylgjiang.stream;

/**
 * @Classname StreamTest
 * @Description Stream测试
 * @Date 2019/10/4 8:44
 * @Created by Jiavg
 */

import club.lylgjiang.lambda.pojo.Employee;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

/**
 *      Stream 是 Java8 中处理集合的关键抽象概念，它可以指定你希望对集合进行的操作，
 * 可以执行非常复杂的查找、过滤和映射数据等操作。
 *      使用Stream API 对集合数据进行操作，就类似于使用 SQL 执行的数据库查询。也可
 * 以使用 Stream API 来并行执行操作。简而言之，Stream API 提供了一种高效且易于使用
 * 的处理数据的方式。
 * 
 * 注意:
 * ①Stream 自己不会存储元素。
 * ②Stream 不会改变源对象。相反，他们会返回一个持有结果的新Stream。
 * ③Stream 操作是延迟执行的。这意味着他们会等到需要结果的时候才执行。
 * 
 * 一.一个Stream的三个操作步骤
 *   ①创建Stream
 *   ②中间操作
 *   ③终止操作(终端操作)
 * 
 */
public class StreamTest {

    /**
     * 创建Stream的四种方式
     */
    @Test
    public void test01(){
        
        // 1.可以通过Collection系列集合提供的的stream()或parallelStream()方法
        List<String> list = Arrays.asList("jlc", "lx", "znc", "ycg");
        Stream<String> stream = list.stream();
        
        // 2.通过Arrays类中的静态方法stream()获取数组流
        String[] strings = {"jlc", "lx", "znc", "ycg"};
        Stream<String> stream1 = Arrays.stream(strings);
        
        // 3.通过Stream类中静态方法of()
        Stream<String> stream2 = Stream.of("jlc", "lx", "znc", "ycg");

        // 4.创建无限流
        // 迭代
        Stream<Integer> stream3 = Stream.iterate(2, (x) -> x * 2);
        stream3.limit(10)
                .forEach(System.out::println);
        
        // 生成
        Stream<Integer> stream4 = Stream.generate(() -> new Random().nextInt());
        stream4.limit(10)
                .forEach(System.out::println);
        
    }
    
}
