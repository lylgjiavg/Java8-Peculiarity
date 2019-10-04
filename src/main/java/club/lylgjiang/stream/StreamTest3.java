package club.lylgjiang.stream;

/**
 * @Classname StreamTest3
 * @Description Stream中间操作
 * @Date 2019/10/4 14:28
 * @Created by Jiavg
 */

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

/**
 * 映射
 * ①map(Function f)
 *      接收一个函数作为参数，该函数会被应用到每个元素上，并将其映射成一个新的元素。
 * ②mapToDouble(ToDoubleFunction f)
 *      接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 DoubleStream。
 * ③mapToInt(ToIntFunction f)
 *      接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 IntStream。
 * ④mapToLong(ToLongFunction f)
 *      接收一个函数作为参数，该函数会被应用到每个元素上，产生一个新的 LongStream。
 * ⑤flatMap(Function f)
 *      接收一个函数作为参数，将流中的每个值都换成另一个流，然后把所有流连接成一个流
 */
public class StreamTest3 {
    
    @Test
    public void test01(){
        
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        Stream<String> stream = Arrays.stream(strings)
                .map((str) -> {
                    return str.substring(0, 1).toUpperCase().concat(str.substring(1));
                });

        stream.forEach(System.out::println);
    }
    
    @Test
    public void test02(){
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        DoubleStream doubleStream = Arrays.stream(strings)
                .mapToDouble((str) -> {
                    switch (str) {
                        case "jlc":
                            return 10000.0;
                        case "znc":
                            return 70000.0;
                        case "lx":
                            return 60000.0;
                        case "ycg":
                            return 50000.0;
                        default:
                            return 6000;
                    }
                });
        
        doubleStream.forEach(System.out::println);
    }
    
    @Test
    public void test03(){
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        IntStream intStream = Arrays.stream(strings)
                .mapToInt((str) -> {
                    return str.length();
                });
        
        intStream.forEach(System.out::println);
    }
    
    @Test
    public void test04(){
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        LongStream longStream = Arrays.stream(strings)
                .mapToLong((str) -> {
                    Long weightValue = 0L;
                    char[] chars = str.toCharArray();
                    for (char aChar : chars) {
                        weightValue += (int)(aChar);
                    }
                    return weightValue;
                });
        
        longStream.forEach(System.out::println);
    }
    
    @Test
    public void test05(){
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        Stream<Stream<Character>> streamStream = Arrays.stream(strings)
                .map(StreamTest3::strToStream);
        
        streamStream.forEach((stream) -> {
            stream.forEach(System.out::println);
        });
    }
    public static Stream<Character> strToStream(String str){
        List list = new ArrayList();
        
        char[] chars = str.toCharArray();
        for (char aChar : chars) {
            list.add(aChar);
        }
        return list.stream(); 
    }
    
    @Test
    public void test06(){
        String[] strings = {"jlc", "znc", "lx", "ycg"};
        Stream<Character> characterStream = Arrays.stream(strings)
                .flatMap(StreamTest3::strToStream);

        characterStream.forEach(System.out::println);
    }
    
}
