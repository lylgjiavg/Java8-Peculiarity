package club.lylgjiang.optional.pojo;

/**
 * @Classname Godness
 * @Description 女神类
 * @Date 2019/10/5 10:02
 * @Created by Jiavg
 */
public class Godness {
    // 名字
    private String name;

    public Godness() {
    }

    public Godness(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Godness{" +
                "name='" + name + '\'' +
                '}';
    }
}
