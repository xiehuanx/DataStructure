package dataStructure.priorityQueue;

/**
 * @author :xie
 * Email: 1487471733@qq.com
 * Date: 2018/12/19
 * Time: 21:31
 * Describe:
 */
public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}
