package club.lylgjiang.optional;

import club.lylgjiang.optional.pojo.Godness;
import club.lylgjiang.optional.pojo.Man;
import club.lylgjiang.optional.pojo.NewMan;
import org.junit.Test;

import java.util.Optional;

/**
 * @Classname OptionalTest2
 * @Description Optional容器测试类
 * @Date 2019/10/5 10:04
 * @Created by Jiavg
 */
public class OptionalTest2 {
    
    @Test
    public void test01(){
        Godness godness = new Godness("熏儿");
        Man man = new Man(godness);
        String godnessName = getGodnessName(man);
        System.out.println("我的女神是:" + godnessName);
    }
    public static final String getGodnessName(Man man){
        if (man != null){
            Godness godness = man.getGodness();
            if(godness != null){
                String godnessName = godness.getName();
                if(godnessName != null){
                    return godnessName;
                }
            }
        }
        return "云芝";
    }
    
     @Test
    public void test02(){
        Optional<Godness> godness = Optional.ofNullable(null);
        Optional<NewMan> newMan = Optional.of(new NewMan(godness));
        String godnessNameOp = getGodnessNameOp(newMan);
        System.out.println(godnessNameOp);
     }
    public static final String getGodnessNameOp(Optional<NewMan> man){
        return man.orElse(new NewMan(Optional.of(new Godness("云芝"))))
                .getGodness()
                .orElse(new Godness("云芝"))
                .getName();
    }
    
    
    
}
