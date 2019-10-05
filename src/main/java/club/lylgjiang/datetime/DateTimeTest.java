package club.lylgjiang.datetime;

import org.junit.Test;

import java.time.*;

/**
 * @Classname DateTimeTest
 * @Description  LocalDate 、LocalTime 、LocalDateTime
 * @Date 2019/10/5 21:47
 * @Created by Jiavg
 */

/**
 * LocalDate、LocalTime、LocalDateTime 类的实例是不可变的对象，分别表示使用 ISO-8601日
 * 历系统的日期、时间、日期和时间。它们提供了简单的日期或时间，并不包含当前的时间信息。
 * 也不包含与时区相关的信息。
 * 
 */
public class DateTimeTest {
    
    @Test
    public void test01(){

        LocalDate localDate = LocalDate.now();
        System.out.println(localDate.toString());   // 2019-10-05

        LocalTime localTime = LocalTime.now();
        System.out.println(localTime.toString());   // 21:51:24.619

        LocalDateTime localDateTime = LocalDateTime.now();
        System.out.println(localDateTime);          // 2019-10-05T21:52:32.777
    }
    
    @Test
    public void test02(){
        LocalDateTime localDateTime = LocalDateTime
                .of(2019, 10, 5, 21, 54, 30);
        // 2019-10-5T21:54:30

//        plusDays, plusWeeks, plusMonths, plusYears
//        向当前 LocalDateTimeDate 对象添加几天、几周、几个月、几年
        LocalDateTime localDateTime1 = localDateTime.plusWeeks(1);
        System.out.println(localDateTime1);
        // 2019-10-12T21:54:30
        
//        minusDays, minusWeeks, minusMonths, minusYears
//        从当前 LocalDate 对象减去几天、几周、几个月、几年
        LocalDateTime localDateTime2 = localDateTime.minusHours(11);
        System.out.println(localDateTime2);
        // 2019-10-05T10:54:30

//        withDayOfMonth, withDayOfYear, withMonth, withYear
//        将月份天数、年份天数、月份、年份修改为指定的值并返回新的 LocalDate 对象
        LocalDateTime localDateTime3 = localDateTime.withDayOfMonth(10);
        System.out.println(localDateTime3);
        // 2019-10-10T21:54:30

        int dayOfYear = localDateTime.getYear();
        int monthValue = localDateTime.getMonthValue();
        int dayOfMonth = localDateTime.getDayOfMonth();
        int value = localDateTime.getDayOfWeek().getValue();
        System.out.printf("%d-%d-%d 星期%d", dayOfYear, monthValue, dayOfMonth, value);
        // 2019-10-5 星期6
    }
    
}
