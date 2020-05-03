package Strategy;

/**
 * @description:
 * @author: YaHe
 * @createDate: 2020/5/3
 * @version: 1.0
 */
public interface Comparator<T> {
    /**
     * o1<o2   return -1
     * o1==o2   return 0
     * o1>o2   return 正数
     * @param o1
     * @param o2
     * @return
     */
    int compare(T o1,T o2);
}
