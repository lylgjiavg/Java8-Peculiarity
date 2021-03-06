package club.lylgjiang.interfacedefault;

/**
 * @Classname MyInterface
 * @Description 接口中的默认方法与静态方法
 * @Date 2019/10/5 22:54
 * @Created by Jiavg
 */

/**
 * Java 8中允许接口中包含具有具体实现的方法，该方法称为
 * “默认方法”，默认方法使用 default 关键字修饰。
 * 
 * 接口中的默认方法
 * 接口默认方法的”类优先”原则
 * 若一个接口中定义了一个默认方法，而另外一个父类或接口中又定义了一个同名的方法时
 *       选择父类中的方法。如果一个父类提供了具体的实现，那么
 *      接口中具有相同名称和参数的默认方法会被忽略。
 *       接口冲突。如果一个父接口提供一个默认方法，而另一个接
 *      口也提供了一个具有相同名称和参数列表的方法（不管方法
 *      是否是默认方法），那么必须覆盖该方法来解决冲突
 * 
 * Java8 中，接口中允许添加静态方法。
 */
@FunctionalInterface
public interface MyInterface {
    
    public static String getAll(){
        return "jlc";
    }
    
    default String getLastName(){
        return "LiCheng";
    }
    
    default String getFirstName(){
        return "Jiang";
    }
    
    String getName();
    
}
