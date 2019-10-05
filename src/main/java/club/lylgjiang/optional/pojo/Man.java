package club.lylgjiang.optional.pojo;

/**
 * @Classname Man
 * @Description 男人类
 * @Date 2019/10/5 10:02
 * @Created by Jiavg
 */
public class Man {
    // 女神
    private Godness godness;

    public Man() {
    }

    public Man(Godness godness) {
        this.godness = godness;
    }

    public Godness getGodness() {
        return godness;
    }

    public void setGodness(Godness godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "Man{" +
                "godness=" + godness +
                '}';
    }
}
