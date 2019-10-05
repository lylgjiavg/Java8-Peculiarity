package club.lylgjiang.datetime;

/**
 * @Classname TemporalAdjusterTest
 * @Description 日期的操纵
 * @Date 2019/10/5 22:23
 * @Created by Jiavg
 */

import org.junit.Test;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

/**
 * TemporalAdjuster : 时间校正器。有时我们可能需要获取例如：将日期调整到“下个周日”等操作。
 * 
 * TemporalAdjusters : 该类通过静态方法提供了大量的常用 TemporalAdjuster的实现。
 * 
 */
public class TemporalAdjusterTest {
    
    @Test
    public void test01(){
        LocalDateTime localDateTime = LocalDateTime
                .of(2019, 10, 5, 22, 25);
        // 2019-10-05T22:25
        
        LocalDateTime with = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        System.out.println(with);
        // 2019-10-01T22:25
        
        // 下一个工作日
        LocalDateTime workDay = localDateTime.with((date) -> {
            LocalDateTime redate = (LocalDateTime) date;
            DayOfWeek dayOfWeek = redate.getDayOfWeek();
            switch (dayOfWeek) {
                case FRIDAY:
                    return redate.plusDays(3);
                case SATURDAY:
                    return redate.plusDays(2);
                default:
                    return redate.plusDays(1);
            }
        });
        System.out.println(workDay);
        // 2019-10-07T22:25
    }
    
}
