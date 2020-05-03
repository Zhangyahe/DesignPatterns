package Strategy;

/**
 * @description:
 * @author: YaHe
 * @createDate: 2020/4/30
 * @version: 1.0
 */
public class Sorter<T> {

    public  void sort(T[] arr,Comparator<T> comparator) {
        for (int i =0;i<arr.length-1;i++){
            int minIndex = i;
            for (int j =i+1;j<arr.length;j++) {
               minIndex = comparator.compare(arr[j] ,arr[minIndex]) == -1? j : minIndex;
            }
            swap(i,minIndex,arr);
        }
    }

    private void swap(int i, int minIndex,T[] arr) {
        T temp = arr[i];
        arr[i] = arr[minIndex];
        arr[minIndex] = temp;
    }
}
