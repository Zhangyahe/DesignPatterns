package Strategy;

import java.util.Arrays;

/**
 * @description:
 * @author: YaHe
 * @createDate: 2020/4/30
 * @version: 1.0
 */
public class Main {
    public static void main(String[] args) {
//        int[] a= {9,2,3,5,7,1,4};
        Cat[] a ={new Cat(1,1),new Cat(2,2)};
        Dog[] d = {new Dog(3),new Dog(5),new Dog(10)};
        Sorter<Dog> sorter = new Sorter<>();
        Sorter<Cat> sorterCat = new Sorter<>();
//        ====Dog的排序===
        sorter.sort(d, new DogComparator());
//         ====Cat的排序===
        sorterCat.sort(a,new CatHeightComparator());
        System.out.println("Dog:"+Arrays.toString(d));
        System.out.println("Cat:"+Arrays.toString(a));
    }
}
