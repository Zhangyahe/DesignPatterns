package SingleMode;

/**
 * @description: 枚举单例；解决线程同步；还可以防止反序列化（枚举类没有构造方法，没法构造它的对象）
 * @author: YaHe
 * @createDate: 2020/4/29
 * @version: 1.0
 */
public enum Single05 {
    INSTANCE;

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single05.INSTANCE.hashCode())).start();
        }
    }
}
