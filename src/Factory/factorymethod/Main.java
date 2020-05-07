package Factory.factorymethod;

/**
 * @description:
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
        //简单工厂
        MoveAble moveAble = new CarFactory().creatCar();
        moveAble.go();
        System.out.println("================================");
        //工厂方法
        MoveAble moveAble1 = new SimpleVehicleFactory().creatBroom();
        moveAble1.go();
    }
}
