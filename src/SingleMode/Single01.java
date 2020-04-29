package SingleMode;

/**
 * @description:单例模式-饿汉式
 * 类加载到内存后，就实例化一个对象，jvm保证线程安全
 * 简单实用
 * 缺点：不管用到与否，类装载时就实现初始化
 * @author: YaHe
 * @createDate: 2020/4/29
 * @version: 1.0
 */
public class Single01 {
    private static final Single01 INSTANCE = new Single01();

    //私有的构造方法，外部无法new对象
    private Single01() {
    }

    public static Single01 getInstance() {
        return INSTANCE;
    }

    //看看是否是一个对象
    public static void main(String[] args) {
        Single01 single01 = Single01.getInstance();
        Single01 single011 = Single01.getInstance();
        System.out.println(single01 == single011);
    }
}
