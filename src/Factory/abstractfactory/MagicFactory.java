package Factory.abstractfactory;

/**
 * @description: 魔法族的工厂--继承抽象工厂----创造魔法产品
 * @author: YaHe
 * @createDate: 2020/5/7
 * @version: 1.0
 */
public class MagicFactory extends AbstractFactory {
    @Override
    Food creatFood() {
        return new MushRoom();
    }

    @Override
    Vehicle creatVehicle() {
        return new Broom();
    }

    @Override
    Weapon creatWeapon() {
        return new MagicStick();
    }
}
