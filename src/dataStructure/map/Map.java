package dataStructure.map;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/17
 * Time: 22:16
 * Describe:
 */
public interface Map<K,V> {

    void add(K key, V value);
    V remove(K key);
    boolean contains(K key);
    V get(K key);
    void set(K key, V newValue);
    int getSize();
    boolean isEmpty();
}
