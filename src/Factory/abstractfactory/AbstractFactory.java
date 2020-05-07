package Factory.abstractfactory;

/**
 * @description: 抽象工厂（名词使用抽象类）
 * 生产食物、交通工具、武器 具体什么食物、什么交通工具、什么武器呢？这就是产品族的概念
 * @author: YaHe
 * @createDate: 2020/5/7
 * @version: 1.0
 */
public abstract class AbstractFactory {
    abstract Food creatFood();
    abstract Vehicle creatVehicle();
    abstract Weapon creatWeapon();
}
