package Factory.abstractfactory;

/**
 * @description: 测试类
 * @author: YaHe
 * @createDate: 2020/5/6
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
     AbstractFactory a = new ModernFactory();

     Vehicle vehicle = a.creatVehicle();
     vehicle.go();
     Weapon weapon = a.creatWeapon();
     weapon.shoot();
     Food food = a.creatFood();
     food.printName();
    }
}
