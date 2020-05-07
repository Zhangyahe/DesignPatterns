package Factory.factorymethod;

/**
 * @description: 简单工厂
 * 就是造汽车的工厂，一个产品、就得一个工厂
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class CarFactory {
    public Car creatCar(){
        System.out.println("a car created");
        return new Car();
    }
}
