package Factory.factorymethod;

/**
 * @description: 可移动---地上开着跑
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class Car implements MoveAble{
    @Override
    public void go() {
        System.out.println("Car go ....");
    }
}
