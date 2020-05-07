package Factory.factorymethod;

/**
 * @description:扫帚
 * 可移动------天上飞着跑
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class Broom implements MoveAble {
    @Override
    public void go() {
        System.out.println("Broom go.....");
    }
}
