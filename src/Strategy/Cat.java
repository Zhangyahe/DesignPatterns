package Strategy;

/**
 * @description:对结构关闭，对扩展开放
 * @author: YaHe
 * @createDate: 2020/4/30
 * @version: 1.0
 */
public class Cat implements Comparable<Cat> {
    int weight,height;

    public Cat(int weight,int height){
        this.weight = weight;
        this.height = height;
    }
    @Override
    public int compareTo(Cat o){
        Cat cat = (Cat) o;
        if(this.weight < cat.weight){
            return -1;
        }else if(this.weight > cat.weight){
            return 1;
        }else{
            return  0;
        }
    }

    @Override
    public String toString() {
        return "Cat{" +
                "weight=" + weight +
                ", height=" + height +
                '}';
    }

}
