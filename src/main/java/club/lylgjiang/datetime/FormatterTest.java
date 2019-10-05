package club.lylgjiang.datetime;

/**
 * @Classname FormatterTest
 * @Description 解析与格式化
 * @Date 2019/10/5 22:34
 * @Created by Jiavg
 */

import org.junit.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * java.time.format.DateTimeFormatter 类：该类提供了三种
 * 格式化方法：
 *  预定义的标准格式
 *  语言环境相关的格式
 *  自定义的格式
 */
public class FormatterTest {
    
    @Test
    public void test01() throws ExecutionException, InterruptedException {

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMdd");

        Callable<LocalDate> task = new Callable<LocalDate>() {

            @Override
            public LocalDate call() throws Exception {
                LocalDate ld = LocalDate.parse("20161121", dtf);
                return ld;
            }

        };

        ExecutorService pool = Executors.newFixedThreadPool(10);

        List<Future<LocalDate>> results = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            results.add(pool.submit(task));
        }

        for (Future<LocalDate> future : results) {
            System.out.println(future.get());
        }

        pool.shutdown();

    }
    
}
