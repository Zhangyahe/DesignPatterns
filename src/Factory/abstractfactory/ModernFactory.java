package Factory.abstractfactory;

/**
 * @description: 现代产品工厂-----继承抽象工厂-----创造现代产品
 * @author: YaHe
 * @createDate: 2020/5/7
 * @version: 1.0
 */
public class ModernFactory extends AbstractFactory {
    @Override
    Food creatFood() {
        return new Bread();
    }

    @Override
    Vehicle creatVehicle() {
        return new Car();
    }

    @Override
    Weapon creatWeapon() {
        return new AK47();
    }
}
