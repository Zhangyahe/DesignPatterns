package Factory.abstractfactory;

import Factory.factorymethod.MoveAble;

/**
 * @description: 交通工具----汽车-----地上跑
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class Car extends Vehicle {
    public void go() {
        System.out.println("Car go ....");
    }
}
