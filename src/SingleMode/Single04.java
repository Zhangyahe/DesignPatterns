package SingleMode;

/**
 * @description: 推荐的完美写法1-使用静态内部类的方式
 * 1、解决什么时候用什么时候加载的问题
 * 2、解决线程安全的问题
 * @author: YaHe
 * @createDate: 2020/4/29
 * @version: 1.0
 */
public class Single04 {
    private Single04() {
    }

    private static class Single04Holder {
        private static final Single04 INSTANCE = new Single04();
    }

    public static Single04 getInstance() {
        return Single04Holder.INSTANCE;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single03.getInstance().hashCode())).start();
        }
    }
}
