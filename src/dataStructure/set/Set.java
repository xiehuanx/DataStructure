package dataStructure.set;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/16
 * Time: 16:42
 * Describe:
 */
public interface Set<E> {
    void add(E e);

    boolean contains(E e);

    void remove(E e);

    int getSize();

    boolean isEmpty();
}
