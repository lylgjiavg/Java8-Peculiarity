package club.lylgjiang.datetime;

/**
 * @Classname ZonedDateTimeTest
 * @Description 时区的处理
 * @Date 2019/10/5 22:49
 * @Created by Jiavg
 */

import org.junit.Test;

import java.time.ZoneId;
import java.util.Set;

/**
 * Java8 中加入了对时区的支持，带时区的时间为分别为：
 *      ZonedDate、ZonedTime、ZonedDateTime
 * 其中每个时区都对应着 ID，地区ID都为 “{区域}/{城市}”的格式
 *      例如 ：Asia/Shanghai 等
 *  ZoneId：该类中包含了所有的时区信息
 *      getAvailableZoneIds() : 可以获取所有时区时区信息
 *      of(id) : 用指定的时区信息获取 ZoneId 对象
 */
public class ZonedDateTimeTest {
    
    @Test
    public void test01(){
        Set<String> availableZoneIds = ZoneId.getAvailableZoneIds();
        availableZoneIds.forEach(System.out::println);
    }
    
}
