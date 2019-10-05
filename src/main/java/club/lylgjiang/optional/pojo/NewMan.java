package club.lylgjiang.optional.pojo;

import java.util.Optional;

/**
 * @Classname NewMan
 * @Description 带有Optional容器的Man
 * @Date 2019/10/5 10:13
 * @Created by Jiavg
 */
public class NewMan {

    // 女神
    private Optional<Godness> godness;
    

    public NewMan(Optional<Godness> godness) {
        this.godness = godness;
    }

    public Optional<Godness> getGodness() {
        return godness;
    }

    public void setGodness(Optional<Godness> godness) {
        this.godness = godness;
    }

    @Override
    public String toString() {
        return "NewMan{" +
                "godness=" + godness +
                '}';
    }
}
