package Strategy;

/**
 * @description:
 * @author: YaHe
 * @createDate: 2020/5/3
 * @version: 1.0
 */
public class Dog implements Comparable<Dog>{
  int food;

    public Dog(int food) {
        this.food =food;
    }

    @Override
    public int compareTo(Dog o) {
        Dog d = (Dog) o;
        if (this.food <d.food){
            return -1;
        }else if(this.food >d.food){
            return 1;
        }else{
            return 0;
        }
    }

    @Override
    public String toString() {
        return "Dog{" +
                "food=" + food +
                '}';
    }
}
