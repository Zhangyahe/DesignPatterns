package Factory.factorymethod;

/**
 * @description:工厂方法
 * 一个工厂可以生产多个产品
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class SimpleVehicleFactory {
    //造汽车
    public Car creatCar(){
        //before processing
        return new Car();
    }
    //造扫帚
    public Broom creatBroom(){
        //before processing
        System.out.println("a Broom created");
        return new Broom();
    }
    //造飞机
    public Plane creatPlane(){
        //before processing
        return new Plane();
    }
}
