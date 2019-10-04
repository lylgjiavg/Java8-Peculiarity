package club.lylgjiang.stream;

import club.lylgjiang.stream.parallel.RecursiveTaskCalculate;
import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.LongStream;

/**
 * @Classname ParallelTest
 * @Description Parallel测试
 * @Date 2019/10/4 22:33
 * @Created by Jiavg
 */
public class ParallelTest {
    
    @Test
    public void test1(){
        Instant start = Instant.now();
        
        ForkJoinPool pool = new ForkJoinPool();
        RecursiveTaskCalculate taskCalculate = new RecursiveTaskCalculate(0L, 1000000000L);
        Long result = taskCalculate.invoke();
        System.out.println(result);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
        //  计算数值        用时          CPU利用率
        //  100000L         28
        //  10000000L       177
        //  1000000000L     5988
    }
    
    @Test
    public void test2(){
        Instant start = Instant.now();

        Long sum = 0L;
        for (Long i = 0L; i <= 1000000000L; i++) {
            sum += i;
        }
        System.out.println(sum);
        
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
        //  计算数值        用时          CPU利用率
        //  100000L         11
        //  10000000L       175
        //  1000000000L     8701
    }
    
    @Test
    public void test3(){
        Instant start = Instant.now();
        
        long reduce = LongStream.range(0, 1000000001L)
                .parallel()
                .reduce(0, Long::sum);

        System.out.println(reduce);
        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());
        //  计算数值        用时          CPU利用率
        //  100000L         69
        //  10000000L       107
        //  1000000000L     388
    }
    
}
