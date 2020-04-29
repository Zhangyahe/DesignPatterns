package SingleMode;

/**
 * @description:单例模式-懒汉式
 * @author: YaHe
 * @createDate: 2020/4/29
 * @version: 1.0
 */
public class Single02 {
    private static Single02 INSTANCE;

    private Single02() {
    }

    private static Single02 getInstance() {
        try {
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //此处线程不安全
        if (INSTANCE == null) {
            INSTANCE = new Single02();
        }
        return INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single02.getInstance().hashCode())).start();
        }
    }
}
