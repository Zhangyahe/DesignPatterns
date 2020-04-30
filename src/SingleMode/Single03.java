package SingleMode;

/**
 * @description:懒汉式
 * @author: YaHe
 * @createDate: 2020/4/29
 * @version: 1.0
 */
public class Single03 {
    private static volatile Single03 INSTANCE;
    private Single03(){
    }

    /**
     * 通过两个判断进行检测，保证线程安全
     * @return
     */
    public static Single03 getInstance(){
        if(INSTANCE == null){
            synchronized (Single03.class){
                if (INSTANCE == null){
                    try {
                        Thread.sleep(1);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    INSTANCE = new Single03();
                }
            }
        }
        return INSTANCE;
    }
    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(() -> System.out.println(Single03.getInstance().hashCode())).start();
        }
    }
}
