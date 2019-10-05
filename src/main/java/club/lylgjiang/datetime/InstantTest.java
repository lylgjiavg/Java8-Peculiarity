package club.lylgjiang.datetime;

import org.junit.Test;

import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.Period;

/**
 * @Classname InstantTest
 * @Description Instant  时间戳
 * @Date 2019/10/5 22:22
 * @Created by Jiavg
 */

/**
 * Instant  时间戳
 * 
 * 用于“时间戳”的运算。它是以Unix元年(传统的设定为UTC时区1970年1月1日午夜时分)
 * 开始所经历的描述进行运算
 */
public class InstantTest {
    
    @Test
    public void test03() throws InterruptedException {
        Instant start = Instant.now();

        Thread.sleep(1000);

        Instant end = Instant.now();
        System.out.println(Duration.between(start, end).toMillis());

        System.out.println("--------------------------------------");
        LocalDate localDate1 = LocalDate.of(2019, 10, 5);

        Thread.sleep(1000);

        LocalDate localDate2 = LocalDate.of(2020, 1, 1);
        int months = Period.between(localDate1, localDate2).getMonths();
        int days = Period.between(localDate1, localDate2).getDays();
        System.out.println(localDate1 + "与" + localDate2 + "相差:" + months + "月" + days +"日");

    }
    
}
